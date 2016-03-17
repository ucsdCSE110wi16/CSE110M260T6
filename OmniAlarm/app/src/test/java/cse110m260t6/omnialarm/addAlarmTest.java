package cse110m260t6.omnialarm;

import android.app.Application;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.test.ViewAsserts;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.test.ActivityInstrumentationTestCase2;

import cse110m260t6.omnialarm.R;
import cse110m260t6.omnialarm.addAlarm;

/**
 * Created by dadongjing on 3/12/16.
 */

@RunWith(AndroidJUnit4.class)
public class addAlarmTest extends ActivityInstrumentationTestCase2<addAlarm>{
    @Rule
    public ActivityTestRule<addAlarm> activityTestRule =
            new ActivityTestRule<>(addAlarm.class);
    public addAlarmTest()
    {
        super(addAlarm.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        getActivity();
    }

    public void testConfirm(){
        String hour = "09";
        String minute = "10";

        onView(withId(R.id.hour)).perform(typeText(hour), closeSoftKeyboard());
        onView(withId(R.id.minute)).perform(typeText(minute), closeSoftKeyboard());

        onView(withId(R.id.confirm)).perform(click());
    }

    public void timeAnimationCheck(){
        onView(withId(R.id.time_string_animation)).check(matches(withText("09:10")));
    }

    public void testJump() {
        onView(withId(R.id.Choose_time)).perform(click());
        onView(withId(R.id.choose_music)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.song1)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.song2)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.song3)).check((ViewAssertion) isDisplayed());
    }

    @Test
    public void testThis(){
        testConfirm();
        timeAnimationCheck();
        testJump();
    }
}
