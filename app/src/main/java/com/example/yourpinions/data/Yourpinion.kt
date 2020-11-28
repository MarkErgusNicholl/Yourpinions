package com.example.yourpinions.data

data class Yourpinion (
    val opinion : String,
    var vote_count : Int = 0,
    var uid : String? = null
)