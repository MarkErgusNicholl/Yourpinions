package com.example.yourpinions

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import com.example.yourpinions.data.Yourpinion
import com.example.yourpinions.ui.main.MainViewModel
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class BaseUiTest {

    @Rule @JvmField
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)
    private val emptyArrayList = MutableLiveData<ArrayList<Yourpinion>>()

    @Mock
    private val mainViewModel: MainViewModel = mock(MainViewModel::class.java)

    @Before
    fun init() {
        `when`(mainViewModel.loadData())
            .thenReturn(returnDummyLiveData())
    }

    private fun returnDummyLiveData(): LiveData<ArrayList<Yourpinion>> {
        return emptyArrayList
    }

    @Test
    fun doNothing() {
        activityTestRule.launchActivity(null)
    }

}