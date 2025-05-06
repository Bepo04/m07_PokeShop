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
class RegisterUITest {

    @get:Rule
    var activityRule = ActivityScenarioRule(Register::class.java)

    @Test
    fun testCampNomUsuariBuitMostraError() {
        onView(withId(R.id.editTextUserName)).perform(clearText())
        onView(withId(R.id.editTextNom)).perform(typeText("Luke"))
        onView(withId(R.id.editTextCognom)).perform(typeText("Skywalker"))
        onView(withId(R.id.editTextEmail)).perform(typeText("skywalker@gmail.com"))
        onView(withId(R.id.editTextAdreca)).perform(typeText("Tatooine"))
        onView(withId(R.id.editTextCP)).perform(typeText("12345"))
        onView(withId(R.id.editTextTelefon)).perform(typeText("612345678"))

        closeSoftKeyboard()
        onView(withId(R.id.buttonRegistrar)).perform(click())

        onView(withId(R.id.textViewError))
            .check(matches(withText("El nom d'usuari és obligatori")))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testCampCorreuInvalidMostraError() {
        onView(withId(R.id.editTextUserName)).perform(typeText("lukesky"))
        onView(withId(R.id.editTextNom)).perform(typeText("Luke"))
        onView(withId(R.id.editTextCognom)).perform(typeText("Skywalker"))
        onView(withId(R.id.editTextEmail)).perform(typeText("skywalker@imperi.com"))
        onView(withId(R.id.editTextAdreca)).perform(typeText("Tatooine"))
        onView(withId(R.id.editTextCP)).perform(typeText("12345"))
        onView(withId(R.id.editTextTelefon)).perform(typeText("612345678"))

        closeSoftKeyboard()
        onView(withId(R.id.buttonRegistrar)).perform(click())

        onView(withId(R.id.textViewError))
            .check(matches(withText("Només s’accepten correus @gmail.com")))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testTelefonInvalidMostraError() {
        onView(withId(R.id.editTextUserName)).perform(typeText("lukesky"))
        onView(withId(R.id.editTextNom)).perform(typeText("Luke"))
        onView(withId(R.id.editTextCognom)).perform(typeText("Skywalker"))
        onView(withId(R.id.editTextEmail)).perform(typeText("skywalker@gmail.com"))
        onView(withId(R.id.editTextAdreca)).perform(typeText("Tatooine"))
        onView(withId(R.id.editTextCP)).perform(typeText("12345"))
        onView(withId(R.id.editTextTelefon)).perform(typeText("12345"))

        closeSoftKeyboard()
        onView(withId(R.id.buttonRegistrar)).perform(click())

        onView(withId(R.id.textViewError))
            .check(matches(withText("El número de telèfon no és vàlid")))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testFormulariValidMostraMissatgeFinal() {
        onView(withId(R.id.editTextUserName)).perform(typeText("lukesky"))
        onView(withId(R.id.editTextNom)).perform(typeText("Luke"))
        onView(withId(R.id.editTextCognom)).perform(typeText("Skywalker"))
        onView(withId(R.id.editTextEmail)).perform(typeText("skywalker@gmail.com"))
        onView(withId(R.id.editTextAdreca)).perform(typeText("Tatooine"))
        onView(withId(R.id.editTextCP)).perform(typeText("12345"))
        onView(withId(R.id.editTextTelefon)).perform(typeText("612345678"))

        closeSoftKeyboard()
        onView(withId(R.id.buttonRegistrar)).perform(click())

        onView(withId(R.id.textViewStatus))
            .check(matches(withText("Registre completat!")))
            .check(matches(isDisplayed()))

        onView(withId(R.id.textViewError))
            .check(matches(withEffectiveVisibility(Visibility.GONE)))
    }
}
