package com.example.fragmentmanager.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import com.example.fragmentmanager.R
import com.example.fragmentmanager.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var manager: FragmentManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        manager = requireActivity().supportFragmentManager
        binding.apply {
            nextButton.setOnClickListener {
                openNextFragmentKt()
            }
        }
        return binding.root
    }

    private fun openNextFragmentKt() {
        manager.commit {
            replace<NewFragment>(R.id.fragmentContainerView)
            setReorderingAllowed(true)
            addToBackStack("")
        }

    }

    private fun openNextFragmentJv() {
        manager.beginTransaction()
            .replace(R.id.fragmentContainerView, NewFragment::class.java, null)
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .commit()
    }
}