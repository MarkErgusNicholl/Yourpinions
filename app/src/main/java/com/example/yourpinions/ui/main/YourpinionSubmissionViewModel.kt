package com.example.yourpinions.ui.main

import androidx.lifecycle.ViewModel
import com.example.yourpinions.repository.YourpinionRepository

class YourpinionSubmissionViewModel : ViewModel() {

    private val repository = YourpinionRepository()

    fun submitYourpinion(opinion: String) {
        repository.addNewYourpinion(opinion)
    }
}