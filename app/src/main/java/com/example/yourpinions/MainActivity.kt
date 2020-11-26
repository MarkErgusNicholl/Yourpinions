package com.example.yourpinions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yourpinions.data.Yourpinion
import com.example.yourpinions.ui.main.MainFragment
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private val db : FirebaseDatabase = FirebaseDatabase.getInstance()
    private val ref : DatabaseReference = db.getReference()

    override fun onCreate(savedInstanceState: Bundle?) {
        val newData = Yourpinion(opinion = "Sarah is pretty girl")
        ref.push().setValue(newData)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}