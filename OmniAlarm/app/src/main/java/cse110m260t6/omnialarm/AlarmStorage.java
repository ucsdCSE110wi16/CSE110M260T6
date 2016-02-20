package cse110m260t6.omnialarm;

import android.app.Application;

/**
 * Created by dadongjing on 2/19/16.
 */
public class AlarmStorage extends Application {
    private Alarm myAlarm;

    public Alarm getMyAlarm(){
        return myAlarm;
    }
    public void setMyAlarm(Alarm alarmIn){
        this.myAlarm = alarmIn;
    }
}
