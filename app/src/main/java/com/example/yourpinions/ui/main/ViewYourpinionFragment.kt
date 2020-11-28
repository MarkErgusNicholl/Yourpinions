package com.example.yourpinions.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.yourpinions.R

class ViewYourpinionFragment : Fragment() {

    companion object {
        fun newInstance() = ViewYourpinionFragment()
    }

    private lateinit var viewModel: ViewYourpinionViewModel
    private lateinit var fullYourpinion: TextView
    private lateinit var voteCount: TextView
    private lateinit var yourpinion: String
    private lateinit var votes: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.view_yourpinion_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fullYourpinion = view.findViewById(R.id.fullYourpinion)
        voteCount = view.findViewById(R.id.expandedYourpinionRating)
        loadArguments()
        fillValues()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ViewYourpinionViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun fillValues() {
        fullYourpinion.text = yourpinion
        voteCount.text = votes
    }

    private fun loadArguments() {
        arguments?.let {
            votes = it.getString("voteCount")!!
            yourpinion = it.getString("opinion")!!

        }
    }

}