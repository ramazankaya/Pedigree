package com.example.kotlinmvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinmvvm.databinding.FragmentTestHelperBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TestHelper.newInstance] factory method to
 * create an instance of this fragment.
 */
class TestHelper : Fragment() {

    private lateinit var binding : FragmentTestHelperBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTestHelperBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textHello.text = "Kaya"

        binding.btnHellper.setOnClickListener {
            binding.textHello.text = "TEk"
            binding.btnHellper.isEnabled = false
            binding.btnHellper.isClickable = false
        }
    }


}