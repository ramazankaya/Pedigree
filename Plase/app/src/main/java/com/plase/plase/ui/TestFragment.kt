package com.plase.plase.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.firebase.firestore.FirebaseFirestore
import com.plase.plase.R
import com.plase.plase.databinding.FragmentNotificationsBinding
import com.plase.plase.databinding.TestFragmentBinding
import com.plase.plase.models.MessageModel
import java.util.*

class TestFragment : Fragment() {

    private lateinit var viewModel: TestViewModel
    private lateinit var binding: TestFragmentBinding

    var db = FirebaseFirestore.getInstance()

    private val TAG = "TestFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.test_fragment, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSender.setOnClickListener {

            val user = hashMapOf(
                "to" to "test",
                "Creator" to "ntRpAN3nIsT31DmO0C37YrRVPBH2",
                "LastUpdateDare" to Date(),
                "CreateDate" to Date()
            )

//
//            var contacts  = Contacts("Uğur", Date(),"MeID", Date())
//
            var message = MessageModel()
            message.from = "Ramaza"
            message.messsage = "Bilem kimlinle görmüşler seni"
            message.detail = "Detay yok war sayılan"
            var uniqueID = UUID.randomUUID().toString()
            db.collection("Contract").document("ntRpAN3nIsT31DmO0C37YrRVPBH2").collection("list")
                .document(uniqueID)
                .set(user)
                .addOnSuccessListener {
                    Log.d(TAG, "DocumentSnapshot added with ID: ")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
            db.collection("Contract").document("vrEzFAi1Qgb4eogub8Qt5PCyMg13").collection("list")
                .document(uniqueID)
                .set(user)
                .addOnSuccessListener {
                    Log.d(TAG, "DocumentSnapshot added with ID: ")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }

//            db.collection("rooms").document("roomA")
//                .collection("messages").document("message1").set(user).
//                addOnSuccessListener {
//                Log.d(TAG, "DocumentSnapshot added with ID: ") }
        }


// Add a new document with a generated ID
//            db.collection("users").documnet("ramzan")
//                .set(user)
//                .addOnSuccessListener { documentReference ->
//                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
//                }
//                .addOnFailureListener { e ->
//                    Log.w(TAG, "Error adding document", e)
//                }


        binding.btnGetData.setOnClickListener {
            db.collection("Contract").document("ntRpAN3nIsT31DmO0C37YrRVPBH2").collection("list")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d(TAG, "${document.id} => ${document.data}")
                    }
                }


//                .document("hnW1cc3lpyElHsO7nGal")
//                .get()
//                .addOnSuccessListener { documentSnapshot ->
//
//                   // val contacts: MessageModel? = documentSnapshot.toObject<MessageModel>()
//
//                   // Log.d(TAG, "onCreateView: ${contacts?.messsage}")
//                    Log.d(TAG, "onCreateView: ${documentSnapshot.data.toString()}")
//                }


        }
    }

}