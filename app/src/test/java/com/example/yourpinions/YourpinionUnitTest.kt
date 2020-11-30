package com.example.yourpinions

import com.example.yourpinions.data.Yourpinion
import org.junit.Assert
import org.junit.Test

class YourpinionUnitTest {
    private val testOpinion = "Test"
    private val testUid = "111000333444"
    private val testVoteCount = 888

    @Test
    fun voteCount_InitAsZero() {
        val testYourpinion = Yourpinion(testOpinion)
        Assert.assertEquals(0, testYourpinion.vote_count)
    }

    @Test
    fun uid_isNullableOnInit() {
        val testYourpinion = Yourpinion(testOpinion, testVoteCount)
        Assert.assertEquals(null, testYourpinion.uid)
    }

    @Test
    fun uid_initProperly() {
        val testYourpinion = Yourpinion(testOpinion, testVoteCount, testUid)
        Assert.assertEquals(testUid, testYourpinion.uid)
    }

    @Test
    fun opinion_initProperly() {
        val testYourpinion = Yourpinion(testOpinion, testVoteCount, testUid)
        Assert.assertEquals(testOpinion, testYourpinion.opinion)
    }

    @Test
    fun voteCount_initProperly() {
        val testYourpinion = Yourpinion(testOpinion, testVoteCount, testUid)
        Assert.assertEquals(testVoteCount, testYourpinion.vote_count)
    }
}