package com.mypackage.espressotestingui;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.squareup.javawriter.JavaWriter.type;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private String mName = "Tony";

    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void testUserInputScenario()
    {
        // input some text in the edit text
        Espresso.onView(withId(R.id.etTextToChange)).perform(typeText(mName));
        // close soft keyboard
        Espresso.closeSoftKeyboard();
        // perform button click
        Espresso.onView(withId(R.id.btnChange)).perform(click());
        // checking the text in the textview
        Espresso.onView(withId(R.id.tvChangedText)).check(matches(withText(mName)));
    }



    @After
    public void tearDown() throws Exception {

    }

}