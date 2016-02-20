package cse110m260t6.omnialarm;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by dadongjing on 2/8/16.
 */

public class Alarm extends Application {

    private Boolean[] activity = new Boolean[7];    /* indicates which days to activite */
    private Calendar Time = Calendar.getInstance(); /* Time of the alarm */
    private String RingTone;

    /* default empty constructor */
    public Alarm(){

    }

    /* one argument constructor */
    public Alarm(Calendar inputT){
        this.Time = inputT;
    }

    /* getter that get alarm activity of each day */
    public Boolean[] getActivity(){
        return this.activity;
    }

    /* set which days to fire the alarm */
    public void setActivity(Boolean[] arr){
        for(int i = 0; i < 7; i++){
            this.activity[i] = arr[i];
        }
    }

    /* return the time setting of this alarm */
    public Calendar getTime(){
        return this.Time;
    }

    /* return the presentation of the time in a string form */
    public String getTimeString(){
        String returnTime = "";
        if(Time.get(Calendar.HOUR_OF_DAY) < 10){
            returnTime += "0";
        }
        returnTime += String.valueOf(Time.get(Calendar.HOUR_OF_DAY));
        returnTime += ":";

        if(Time.get((Calendar.MINUTE)) < 10){
            returnTime += "0";
        }
        returnTime += String.valueOf(Time.get(Calendar.MINUTE));
        return returnTime;
    }

    /* get the ringtone path */
    public String getRingTone(){
        return this.RingTone;
    }

    /* set the ringtone for the alarm */
    public void setRingTone(String ringTone){
        this.RingTone = ringTone;
    }


}
