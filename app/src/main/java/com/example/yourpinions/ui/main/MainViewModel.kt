package com.example.yourpinions.ui.main

import androidx.lifecycle.ViewModel
import com.example.yourpinions.data.Yourpinion
import com.example.yourpinions.repository.YourpinionRepository

class MainViewModel : ViewModel() {
    private val repo = YourpinionRepository()

    fun loadData() : ArrayList<Yourpinion> {
        return repo.retrieveTop20Yourpinions()
    }
}