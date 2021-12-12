package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentResultsBinding
import com.example.myapplication.model.UserAnswers


class ResultsFragment : Fragment(R.layout.fragment_results) {

    private var _binding : FragmentResultsBinding? = null
    private val binding get() = _binding!!
    private lateinit var final: UserAnswers


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {bundle ->

            final = bundle.getParcelable("final")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentResultsBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.firstResult.text = final.firstQuestion
        binding.secondResult.text = final.secondQuestion
        binding.thirdResult.text = final.thirdQuestions
        binding.fourthResult.text = final.fourthQuestion


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}