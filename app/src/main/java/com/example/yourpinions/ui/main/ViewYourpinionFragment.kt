package com.example.yourpinions.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat
import com.example.yourpinions.R

class ViewYourpinionFragment : Fragment() {

    companion object {
        fun newInstance() = ViewYourpinionFragment()
    }

    private lateinit var viewModel: ViewYourpinionViewModel
    private lateinit var fullYourpinion: TextView
    private lateinit var voteCount: TextView
    private lateinit var yourpinion: String
    private lateinit var uid: String
    private lateinit var votes: String
    private lateinit var upvote: AppCompatImageButton
    private lateinit var downvote: AppCompatImageButton

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
        upvote = view.findViewById(R.id.upvote)
        downvote = view.findViewById(R.id.downvote)
        loadArguments()
        fillValues()
        activateButtonOnClickListeners()
    }

    private fun activateButtonOnClickListeners() {
        upvote.setOnClickListener {
            viewModel.upvotePressed(uid, votes.toInt())
            voteCount.startAnimation(AnimationUtils.loadAnimation(this.activity, android.R.anim.fade_in))
            voteCount.setTextColor(resources.getColor(R.color.green))
            voteCount.text = createNewUpvoteVal(votes.toInt())
        }

        downvote.setOnClickListener {
            viewModel.downvotePressed(uid, votes.toInt())
            voteCount.startAnimation(AnimationUtils.loadAnimation(this.activity, android.R.anim.fade_in))
            voteCount.setTextColor(resources.getColor(R.color.red))
            voteCount.text = createNewDownvoteVal(votes.toInt())
        }
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
            uid = it.getString("uid")!!
        }
    }

    private fun createNewUpvoteVal(oldVoteCount: Int) : String {
        return when {
            oldVoteCount == -1 -> {
                "0"
            }
            oldVoteCount > -1 -> {
                ("+" + (oldVoteCount + 1).toString())
            }
            else -> ("-" + (oldVoteCount + 1).toString())
        }
    }

    private fun createNewDownvoteVal(oldVoteCount: Int) : String {
        return when {
            oldVoteCount == 1 -> {
                "0"
            }
            oldVoteCount > 1 -> {
                ("+" + (oldVoteCount - 1).toString())
            }
            else -> ("-" + (oldVoteCount - 1).toString())
        }
    }

}