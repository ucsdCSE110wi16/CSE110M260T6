package cse110m260t6.omnialarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ted on 16/2/29.
 */
public class selectAlarm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_alarm);

        Alarm tempAlarm;

        tempAlarm = Database.getAlarm();
        tempAlarm.setDate(1, true);

        Database.insertAlarm(tempAlarm);

        Intent goback = new Intent(this, cse110m260t6.omnialarm.main_ac.class);
        startActivity(goback);


    }
}
