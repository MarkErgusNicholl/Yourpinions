package com.example.yourpinions

import com.example.yourpinions.data.Yourpinion
import org.junit.Assert
import org.junit.Test

class YourpinionUnitTest {
    @Test
    fun voteCount_InitAsZero() {
        val testOpinion : Yourpinion = Yourpinion("Test")
        Assert.assertEquals(0, testOpinion.vote_count)
    }
}