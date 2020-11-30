package com.example.yourpinions.ui.main

import androidx.lifecycle.ViewModel
import com.example.yourpinions.repository.YourpinionRepository

class ViewYourpinionViewModel : ViewModel() {
    private val repo = YourpinionRepository()

    fun upvotePressed(uid: String, currentVoteCount: Int) {
        repo.upvote(uid, currentVoteCount)
    }

    fun downvotePressed(uid: String, currentVoteCount: Int) {
        repo.downvote(uid, currentVoteCount)
    }
}