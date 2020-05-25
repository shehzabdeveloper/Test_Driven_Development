package com.shehzabahammad.test_drivendevelopment.login

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.shehzabahammad.test_drivendevelopment.R
import com.shehzabahammad.test_drivendevelopment.home.HomeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    var activityTestRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun isUsernameEditTextDisplayed() {
        activityTestRule.launchActivity(Intent())
        onView(withId(R.id.etUsername)).check(matches(isDisplayed()))
    }

    @Test
    fun isUserLoggedAndHomeScreenCalled() {
        activityTestRule.launchActivity(Intent())

        //entering username
        onView(withId(R.id.etUsername)).perform(
            ViewActions.typeText("android"),
            ViewActions.closeSoftKeyboard()
        )

        //entering password
        onView(withId(R.id.etPassword)).perform(
            ViewActions.typeText("123456"),
            ViewActions.closeSoftKeyboard()
        )

        //checking  HomeActivity is called
        Intents.init()
        onView(withId(R.id.btnLogin)).perform(ViewActions.click())
        Intents.intended(IntentMatchers.hasComponent(HomeActivity::class.java.name))
        Intents.release()
    }

}