package cse110m260t6.omnialarm;

/**
 * Created by dadongjing on 3/16/16.
 */
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by dadongjing on 3/12/16.
 */

@RunWith(AndroidJUnit4.class)
public class addAlarmTest extends ActivityInstrumentationTestCase2<main_ac>{
    @Rule
    public ActivityTestRule<main_ac> activityTestRule =
            new ActivityTestRule<>(main_ac.class);
    public addAlarmTest()
    {
        super(main_ac.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        getActivity();
    }

    public void testadd() {
        onView(withId(R.id.addBtn)).perform(click());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
    }
    public void testInput(){
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
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){

        }
        onView(withId(R.id.choose_music)).check(matches(isDisplayed()));
        onView(withId(R.id.song1)).check(matches(isDisplayed()));
        onView(withId(R.id.song2)).check(matches(isDisplayed()));
        onView(withId(R.id.song3)).check(matches(isDisplayed()));
    }

    @Test
    public void testThis(){
        testadd();
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){

        }
        testInput();
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){

        }
        timeAnimationCheck();
        testJump();
    }
}