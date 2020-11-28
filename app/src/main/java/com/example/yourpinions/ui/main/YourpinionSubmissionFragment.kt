package com.example.yourpinions.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.yourpinions.R

class YourpinionSubmissionFragment : Fragment() {

    companion object {
        fun newInstance() = YourpinionSubmissionFragment()
    }

    private lateinit var viewModel: YourpinionSubmissionViewModel
    private lateinit var submissionField: EditText
    private lateinit var charCount: TextView
    private lateinit var submitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.yourpinion_submission_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submissionField = view.findViewById(R.id.yourpinionInputField)
        charCount = view.findViewById(R.id.charCount)
        submitButton = view.findViewById(R.id.submitYourpinion)
        countCharactersOfInput()
        listenToUserSubmission()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(YourpinionSubmissionViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun countCharactersOfInput() {
        submissionField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.let {
                    charCount.text = it.length.toString()
                    charCount.setTextColor(resources.getColor(R.color.white))
                    if (it.length > 255) {
                        charCount.setTextColor(resources.getColor(R.color.red))
                    }
                }
            }

        })
    }

    private fun listenToUserSubmission() {
        submitButton.setOnClickListener {
            val opinion = submissionField.text.toString()
            viewModel.submitYourpinion(opinion)
            Toast.makeText(activity,"Your Yourpinion is heard!", Toast.LENGTH_SHORT).show()
            activity!!.onBackPressed()
        }
    }

}