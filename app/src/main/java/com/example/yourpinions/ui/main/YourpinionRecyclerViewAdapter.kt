package com.example.yourpinions.ui.main

import android.app.LauncherActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yourpinions.R

class YourpinionRecyclerViewAdapter() : RecyclerView.Adapter<YourpinionRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val yourpinionText: TextView
        val voteCountText: TextView

        init {
            // Define click listener for the ViewHolder's View.
            yourpinionText = view.findViewById(R.id.yourpinion)
            voteCountText = view.findViewById(R.id.votecount)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourpinionRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_yourpinion_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: YourpinionRecyclerViewAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}