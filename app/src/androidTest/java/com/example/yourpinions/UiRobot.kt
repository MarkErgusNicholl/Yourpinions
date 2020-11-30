package com.example.yourpinions

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers

class UiRobot {

    fun pressWithId(resId: Int) {
        Espresso.onView(ViewMatchers.withId(resId))
            .perform(click())
    }

    fun isDisplayedOnScreen(resId: Int) {
        Espresso.onView(ViewMatchers.withId(resId))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}