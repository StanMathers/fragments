package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentQuestionsBinding
import com.example.myapplication.model.UserAnswers

class QuestionsFragment : Fragment(R.layout.fragment_questions) {

    private var _binding: FragmentQuestionsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentQuestionsBinding.inflate(
            inflater,
            container,
            false
        )


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submitButton.setOnClickListener {
            val first = binding.firstAnswer.text.toString().trim()
            val second = binding.secondAnswer.text.toString().trim()
            val third = binding.thirdAnswer.text.toString().trim()
            val fourth = binding.fourthAnswer.text.toString().trim()
            
            if(first.isNotEmpty() && second.isNotEmpty() && third.isNotEmpty() && fourth.isNotEmpty()) {

                val final = UserAnswers(first, second, third, fourth)
                val bundle = bundleOf("final" to final)

                view.findNavController().navigate(R.id.resultsFragment, bundle)

            }else{
                Toast.makeText(activity, "Fill all the answers", Toast.LENGTH_LONG).show()
            }



        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}