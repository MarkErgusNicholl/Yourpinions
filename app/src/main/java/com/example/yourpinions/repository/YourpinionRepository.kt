package com.example.yourpinions.repository

import android.os.Debug
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.yourpinions.data.Yourpinion
import com.google.firebase.database.*
import kotlinx.coroutines.flow.Flow

// For this simple app, we will use a simple repository class instead of DI and data layer.
class YourpinionRepository {
    // We begin this project by using LiveData from this layer, but ideally when the repos
    // are decoupled into different modules, suspend funcs(??) should be used to
    // instantiate LiveData in the viewModel
    private val db : FirebaseDatabase = FirebaseDatabase.getInstance()
    private val ref : DatabaseReference = db.getReference()
    private val yourpinionList = MutableLiveData<ArrayList<Yourpinion>>()

    fun addNewYourpinion(opinion: String) {
        // Create a Yourpinion object and store in Firebase. Push() generates a UID.
        val yourpinion = Yourpinion(opinion = opinion)
        ref.push().setValue(yourpinion)
    }

    fun upvote(uid: String) {
        //TODO: FIX
    }

    fun downvote(uid: String) {
        //TODO: FIX
    }

    fun retrieveTop20Yourpinions() : MutableLiveData<ArrayList<Yourpinion>> {
        var listOfYourpinion = ArrayList<Yourpinion>()
        // Sort the data by vote counts, and load first 20 only
        ref.orderByChild("vote_count").addChildEventListener(object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
            }

            override fun onChildChanged(data: DataSnapshot, p1: String?) {
            }

            override fun onChildAdded(data: DataSnapshot, p1: String?) {
                var opinion = data.child("opinion").value as String
                var votes = data.child("vote_count").value as Long
                var votesInt = votes.toInt()
                var uid = data.key
                listOfYourpinion.add(0, Yourpinion(opinion, votesInt, uid))
                yourpinionList.value = listOfYourpinion
            }

            override fun onChildRemoved(p0: DataSnapshot) {
            }

        })

        return yourpinionList
    }

    // TODO: More Operations
}