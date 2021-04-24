package com.plase.plase.ui.login

import android.content.Intent
import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.plase.plase.MainActivity
import com.plase.plase.R
import com.plase.plase.databinding.LoginFragmentBinding
import com.plase.plase.model.api.entry.UserContract
import java.util.*

class LoginFragment : FragmentActivity(), LoginEvent {
    private val TAG = "LoginFragment"
    private val RC_SIGN_IN: Int = 345
    private lateinit var auth: FirebaseAuth

    companion object {
        fun newInstance() = LoginFragment()
    }

    private var firebaseStore = FirebaseFirestore.getInstance()
    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.login_fragment)
        binding.loginEventListener = this


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        auth = FirebaseAuth.getInstance()
//        auth.signOut()
        updateUI(auth.currentUser)

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        //val credential = GoogleAuthProvider.getCredential("102985610566226843754", null)
//        val currentUser = auth.currentUser

    }

    fun updateUI(user: FirebaseUser?) {

        user?.let {
            firebaseStore.collection("Users").document(user.uid).set(
                UserContract(
                    user.uid, user.displayName, user.email,
                    Build.MODEL,
                    "Build.VERSION_CODES",
                    Date()
                )
            ).addOnSuccessListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }.addOnFailureListener{e ->
                Log.w(TAG, "Error adding document", e)
            }

        }
        println("login ${user?.email}")
    }


    override fun onClickLogin() {

        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                Log.d("Login", "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("Login", "Google sign in failed", e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Login", "signInWithCredential:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Login", "signInWithCredential:failure", task.exception)
                    updateUI(null)
                }
            }
    }


}