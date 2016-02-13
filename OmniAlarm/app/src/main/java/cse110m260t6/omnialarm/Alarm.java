package cse110m260t6.omnialarm;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by dadongjing on 2/8/16.
 */
public class Alarm implements Serializable {

    private Boolean[] activity = new Boolean[7];
    private Calendar Time = Calendar.getInstance();


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

    public void setActivity(Boolean[] arr){
        for(int i = 0; i < 7; i++){
            this.activity[i] = arr[i];
        }
    }

    public Calendar getTime(){
        return this.Time;
    }

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


}
