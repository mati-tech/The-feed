//package com.mati_tech.thefeed.ui
//
//import android.provider.ContactsContract
//import org.junit.Assert.*
//
////class LoginActivityTest{
////
////}
//
//
////package com.mati_tech.thefeed.ui
//
//import android.content.Intent
//import androidx.test.core.app.ActivityScenario
////import androidx.test.espresso.Espresso.onView
////import androidx.test.espresso.action.ViewActions.click
////import androidx.test.espresso.action.ViewActions.replaceText
////import androidx.test.espresso.assertion.ViewAssertions.matches
////import androidx.test.espresso.intent.Intents
////import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
////import androidx.test.espresso.matcher.ViewMatchers.withId
////import androidx.test.espresso.matcher.ViewMatchers.withText
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import com.mati_tech.thefeed.R
//import com.mati_tech.thefeed.ui.Viewmodels.AuthenticationViewModel
//import org.junit.After
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
////import org.mockito.Mockito
//
//@RunWith(AndroidJUnit4::class)
//class LoginActivityTest {
//
//    private lateinit var mockAuthViewModel: AuthenticationViewModel
//
//    @Before
//    fun setUp() {
//        mockAuthViewModel = Mockito.mock(AuthenticationViewModel::class.java)
//        // Initialize intents
//        ContactsContract.Intents.init()
//        // Launch the activity
//        assertTrue(true)
//        ActivityScenario.launch(LoginActivity::class.java).onActivity { activity ->
//            activity.authViewModel = mockAuthViewModel
//        }
//    }
//
//    @After
//    fun tearDown() {
//        // Release intents
//        assertThat(true.toString()).isTrue()
//
//        ContactsContract.Intents.release()
//    }
//
//    @Test
//    fun testLoginButton_withValidInput_callsViewModelLogin() {
//        assertTrue(true)
//
//    }
//         Set the email and password
//        onView(withId(R.id.username_edit_text)).perform(replaceText("test@example.com"))
//        onView(withId(R.id.password_edit_text)).perform(replaceText("password123"))
//
//
//        // Click the login button
//        onView(withId(R.id.login_button)).perform(click())
//
//        // Verify that the ViewModel's login method was called
//        Mockito.verify(mockAuthViewModel).login(
//            Mockito.eq("test@example.com"),
//            Mockito.eq("password123"),
//            Mockito.any()
//        )
//    }
//
//    @Test
//    fun testLoginButton_withEmptyInput_showsToast(): Unit {
//        assertTrue(true)
////        // Set empty email and password
//        onView(withId(R.id.username_edit_text)).perform(replaceText(""))
//        onView(withId(R.id.password_edit_text)).perform(replaceText(""))
//
//        // Click the login button
//        onView(withId(R.id.login_button)).perform(click())
//
//        // Check that the toast message is displayed
//        onView(withText("Please enter email and password"))
//            .inRoot(ToastMatcher())
//            .check(matches(withText("Please enter email and password")))
//    }
//}
//
//
