package cse110m260t6.omnialarm;

import android.support.test.espresso.ViewAssertion;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by dadongjing on 3/12/16.
 */
@RunWith(AndroidJUnit4.class)
public class addWakeUpTest extends ActivityInstrumentationTestCase2<wakeupAc> {
    @Rule
    public ActivityTestRule<wakeupAc> activityTestRule =
            new ActivityTestRule<>(wakeupAc.class);
    public addWakeUpTest()
    {
        super(wakeupAc.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        getActivity();
    }

    public void wakeupacAnimationCheck(){

        onView(withId(R.id.math)).perform(click());
        onView(withId(R.id.activity_string)).check(matches(withText("Solve Math Problem")));

    }

    public void testJump() {

        onView(withId(R.id.choose_wake_up)).perform(click());

        onView(withId(R.id.monday)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.tuesday)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.wednesday)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.thursday)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.friday)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.saturday)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.sunday)).check((ViewAssertion) isDisplayed());

        onView(withId(R.id.monday_time)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.tuesday_time)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.wednesday_time)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.thursday_time)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.friday_time)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.saturday_time)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.sunday_time)).check((ViewAssertion) isDisplayed());


        onView(withId(R.id.addBtn)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.delete_alarm)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.delete_by_id)).check((ViewAssertion) isDisplayed());
    }

    @Test
    public void testThis(){
        wakeupacAnimationCheck();
        testJump();
    }
}
