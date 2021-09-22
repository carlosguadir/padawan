package com.ceiba.padawan

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import kotlinx.coroutines.delay
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
@LargeTest
class UsersActivityTest {

    private lateinit var stringToBetyped: String

    @get:Rule
    val activityRule = ActivityScenarioRule(UsersActivity::class.java)


    @Before
    fun configure() {
        stringToBetyped = "Clementine"
    }

    @Test
    suspend fun searchClementine() {
        // Maybe the first time, API will haven't respond
        delay( 500 )
        onView( withId( R.id.action_search ) ).perform( click() )
        onView( withId( R.id.search_src_text ) ).perform( typeText( stringToBetyped ) )
        onView( withId( R.id.users_list ) )
            .perform( scrollToPosition<RecyclerView.ViewHolder>(1))
            .check( matches( hasDescendant( withText( "Clementine Bauch" ) ) ) )
    }
}
    