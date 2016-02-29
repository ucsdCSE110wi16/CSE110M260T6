package cse110m260t6.omnialarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by Ted on 16/2/29.
 */
public class selectAlarm extends AppCompatActivity {

    List<Alarm> alarmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_alarm);

        alarmList = Database.getAll();
        Alarm tempAlarm;

        if(alarmList != null) {
            if(alarmList.get(0) != null) {
                tempAlarm = alarmList.get(0);
                tempAlarm.setDate(1, true);
                Database.updateById(tempAlarm.getIDString(), tempAlarm);
            }
            if(alarmList.get(1) != null) {
                tempAlarm = alarmList.get(1);
                tempAlarm.setDate(2, true);
                Database.updateById(tempAlarm.getIDString(), tempAlarm);
            }
        }


        Intent goback = new Intent(this, cse110m260t6.omnialarm.main_ac.class);
        startActivity(goback);

    }
}
