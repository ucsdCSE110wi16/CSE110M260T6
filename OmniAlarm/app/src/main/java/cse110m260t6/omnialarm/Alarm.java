package cse110m260t6.omnialarm;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by dadongjing on 2/8/16.
 */

public class Alarm extends Application {
    //activity[0 ... 6] indicates sunday to saturday
    private Boolean[] activity = new Boolean[7];    /* indicates which days to activate */
    private Calendar Time = Calendar.getInstance(); /* Time of the alarm */
    private String RingTone;
    private String wake_up_activity;
    private int AlarmID;

    /* default empty constructor */
    public Alarm(){
        int i;
        for(i = 0; i < 7; i++) activity[i] = false;
    }

    /* one argument constructor */
    public Alarm(Calendar inputT){
        int i;
        for(i = 0; i < 7; i++) activity[i] = false;
        this.Time = inputT;
    }

    /* three arguments(string) constructor */
    public Alarm(String ID, String Time,String ringtone, String wu_activity, String date){
        int i;
        for(i = 0; i < 7; i++) activity[i] = false;
        this.setIDS(ID);
        this.setTimeS(Time);
        this.setRingTone(ringtone);
        this.setWake_up_activity(wu_activity);
        this.setDateS(date);
    }

    public void setIDS(String ID) {
        AlarmID = Integer.parseInt(ID);
    }

    public String getIDString() {
        return ""+AlarmID;
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

    /* set time method to set the alarm time */
    public void setTime(Calendar calendar){
        this.Time = calendar;
    }

    /* set time method based on time string from database */
    public void setTimeS(String time){
        //create a new calendar
        Calendar alarmCal = Calendar.getInstance();

        //split the time string from :
        String[] timeParts = time.split(":");
        String hour = timeParts[0];
        String minute = timeParts[1];

        //update the calendar
        alarmCal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(hour));
        alarmCal.set(Calendar.MINUTE,Integer.parseInt(minute));
        alarmCal.set(Calendar.MILLISECOND, 0);


        //update the alarm time
        setTime(alarmCal);
    }

    public void setDateS(String date) {
        int i;
        //if(!date.equals(""))
            for(i = 0; i < 7; i++) {
                if(date.charAt(i) == '0')
                    activity[i] = false;
                else
                    activity[i] = true;
            }
        //else for(i = 0; i < 7; i++) activity[i] = false;
    }

    public String getDateString() {
        String returnDate = "";
        int i;
        for(i = 0; i < 7; i++) {
            Log.e("activity", activity[i].toString());
            if(activity[i])
                returnDate += "1";
            else
                returnDate += "0";
        }
        Log.e("return", returnDate);
        return returnDate;
    }

    public Boolean[] getDate() {
        return activity;
    }

    public void setDate(int date, boolean ac) {
        activity[date] = ac;
    }

    /*get alarm id*/
    public int getAlarmID(Alarm myAlarm){
        return this.AlarmID;
    }

    /*set alarm id*/
    public void setAlarmID(int id){
        this.AlarmID = id;
    }

    /* get the ringtone path */
    public String getRingTone(){
        return this.RingTone;
    }

    /* set the ringtone for the alarm */
    public void setRingTone(String ringTone){
        this.RingTone = ringTone;
    }

    /* get the wake_up_activity string */
    public String getWake_up_activity(){
        return this.wake_up_activity;
    }

    /* set the wake_up_activity string */
    public void setWake_up_activity(String activity){
        this.wake_up_activity = activity;
    }


}
