package com.ericandpau.pokeshopk

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginUITest {

    @get:Rule
    var activityRule = ActivityScenarioRule(Login::class.java)

    @Test
    fun testEmailBuitMostraError() {
        onView(withId(R.id.editTextTextEmailAddress)).perform(clearText())
        onView(withId(R.id.editTextTextPassword)).perform(typeText("ContrasenyaSegura1!"))
        closeSoftKeyboard()
        onView(withId(R.id.callback)).perform(click())

        onView(withId(R.id.textViewLoginError))
            .check(matches(withText("El correu és obligatori")))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testPasswordBuitMostraError() {
        onView(withId(R.id.editTextTextEmailAddress)).perform(typeText("prova@gmail.com"))
        onView(withId(R.id.editTextTextPassword)).perform(clearText())
        closeSoftKeyboard()
        onView(withId(R.id.callback)).perform(click())

        onView(withId(R.id.textViewLoginError))
            .check(matches(withText("La contrasenya és obligatòria")))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testPasswordMassaFacilMostraError() {
        onView(withId(R.id.editTextTextEmailAddress)).perform(typeText("prova@gmail.com"))
        onView(withId(R.id.editTextTextPassword)).perform(typeText("12345678"))
        closeSoftKeyboard()
        onView(withId(R.id.callback)).perform(click())

        onView(withId(R.id.textViewLoginError))
            .check(matches(withText("La contrasenya és massa fàcil, tria una contrasenya més segura")))
            .check(matches(isDisplayed()))
    }

}
