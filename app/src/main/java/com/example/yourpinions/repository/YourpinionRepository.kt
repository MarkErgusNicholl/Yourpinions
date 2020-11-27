package com.example.yourpinions.repository

import android.os.Debug
import android.util.Log
import com.example.yourpinions.data.Yourpinion
import com.google.firebase.database.*

// For this simple app, we will use a simple repository class instead of DI and data layer.
class YourpinionRepository {
    private val db : FirebaseDatabase = FirebaseDatabase.getInstance()
    private val ref : DatabaseReference = db.getReference()

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

    // TODO: More Operations
}