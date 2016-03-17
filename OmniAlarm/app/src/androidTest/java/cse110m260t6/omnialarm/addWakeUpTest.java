package cse110m260t6.omnialarm;

/**
 * Created by Boyu on 3/16/16.
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
 * Created by Boyu on 3/16/16.
 */
@RunWith(AndroidJUnit4.class)
public class addWakeUpTest extends ActivityInstrumentationTestCase2<main_ac> {
    @Rule
    public ActivityTestRule<main_ac> activityTestRule =
            new ActivityTestRule<>(main_ac.class);

    public addWakeUpTest()
    {
        super(main_ac.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        getActivity();
    }

    public void clickadd() {
        onView(withId(R.id.addBtn)).perform(click());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
    }
    public void inputtime(){
        String hour = "09";
        String minute = "10";

        onView(withId(R.id.hour)).perform(typeText(hour), closeSoftKeyboard());
        onView(withId(R.id.minute)).perform(typeText(minute), closeSoftKeyboard());

        onView(withId(R.id.confirm)).perform(click());
    }

    public void timeAnimationCheck(){
        onView(withId(R.id.time_string_animation)).check(matches(withText("09:10")));
    }

    public void jump() {
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


    public void ringtoneAnimationCheck(){

        onView(withId(R.id.song1)).perform(click());
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){

        }
        onView(withId(R.id.ring)).check(matches(withText("father")));

    }

    public void jumpagain() {

        onView(withId(R.id.choose_music)).perform(click());
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){

        }

        onView(withId(R.id.button3)).check(matches(isDisplayed()));
        onView(withId(R.id.reverse)).check(matches(isDisplayed()));
        onView(withId(R.id.math)).check(matches(isDisplayed()));
        onView(withId(R.id.choose_wake_up)).check(matches(isDisplayed()));
    }

    public void wakeupacAnimationCheck(){

        onView(withId(R.id.math)).perform(click());
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){

        }

        onView(withId(R.id.activity_string)).check(matches(withText("Solve Math Problem")));

    }

    public void testJump() {

        onView(withId(R.id.choose_wake_up)).perform(click());
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){

        }

        onView(withId(R.id.monday)).check(matches(isDisplayed()));
        onView(withId(R.id.tuesday)).check(matches(isDisplayed()));
        onView(withId(R.id.wednesday)).check(matches(isDisplayed()));
        onView(withId(R.id.thursday)).check(matches(isDisplayed()));
        onView(withId(R.id.friday)).check(matches(isDisplayed()));
        onView(withId(R.id.saturday)).check(matches(isDisplayed()));
        onView(withId(R.id.sunday)).check(matches(isDisplayed()));

        onView(withId(R.id.monday_time)).check(matches(isDisplayed()));
        onView(withId(R.id.tuesday_time)).check(matches(isDisplayed()));
        onView(withId(R.id.wednesday_time)).check(matches(isDisplayed()));
        onView(withId(R.id.thursday_time)).check(matches(isDisplayed()));
        onView(withId(R.id.friday_time)).check(matches(isDisplayed()));
        onView(withId(R.id.saturday_time)).check(matches(isDisplayed()));
        onView(withId(R.id.sunday_time)).check(matches(isDisplayed()));


        onView(withId(R.id.addBtn)).check(matches(isDisplayed()));
        onView(withId(R.id.delete_alarm)).check(matches(isDisplayed()));
        onView(withId(R.id.delete_by_id)).check(matches(isDisplayed()));
    }



    @Test
    public void testThis(){
        clickadd();
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){

        }
        inputtime();
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){

        }
        timeAnimationCheck();
        jump();

        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){

        }

        ringtoneAnimationCheck();
        jumpagain();

        wakeupacAnimationCheck();
        testJump();

    }
}

