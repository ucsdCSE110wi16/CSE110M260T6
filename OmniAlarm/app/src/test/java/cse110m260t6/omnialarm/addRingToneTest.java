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
public class addRingToneTest extends ActivityInstrumentationTestCase2<ringTone> {
    @Rule
    public ActivityTestRule<ringTone> activityTestRule =
            new ActivityTestRule<>(ringTone.class);
    public addRingToneTest()
    {
        super(ringTone.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        getActivity();
    }

    public void ringtoneAnimationCheck(){

        onView(withId(R.id.song1)).perform(click());
        onView(withId(R.id.ring)).check(matches(withText("father")));

    }

    public void testJump() {

        onView(withId(R.id.choose_music)).perform(click());

        onView(withId(R.id.button3)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.reverse)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.math)).check((ViewAssertion) isDisplayed());
        onView(withId(R.id.choose_wake_up)).check((ViewAssertion) isDisplayed());
    }

    @Test
    public void testThis(){
        ringtoneAnimationCheck();
        testJump();
    }
}
