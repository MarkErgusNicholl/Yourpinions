package com.example.yourpinions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yourpinions.ui.main.MainFragment
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private var db : FirebaseDatabase = FirebaseDatabase.getInstance()
    private var ref : DatabaseReference = db.getReference("yourpinions")

    override fun onCreate(savedInstanceState: Bundle?) {
        ref.setValue("Hi")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}