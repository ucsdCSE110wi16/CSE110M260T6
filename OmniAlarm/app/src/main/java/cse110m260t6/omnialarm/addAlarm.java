package cse110m260t6.omnialarm;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by dadongjing on 2/6/16.
 */
public class addAlarm extends AppCompatActivity{

        Button choose_time;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.add_alarm);


            //find the button by id
            choose_time = (Button)findViewById(R.id.Choose_time);
            
            /* add button logic design */
            choose_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /* for the time picker, we need to check if it support API 16. Otherwise,
                     * we are going to use text box in the xml file to obtain hour and minute.
                     */
                    /*
                    TimePicker myTimeP = (TimePicker) findViewById(R.id.timePicker2);
                    int hour = myTimeP.getHour();
                    int minute = myTimeP.getMinute();
                    */

                    //Calendar myCa = Calendar.getInstance();
                    //myCa.set(0,0,0,hour,minute);

                    //get the default alarm from the database
                    //Alarm myAlarm = getAlarm(0);
                    //myAlarm.setTime(myCa);
                    //


                    //jump to next page that prompt user to enter ring tone
                    Intent jumpActivity = new Intent(v.getContext(), cse110m260t6.omnialarm.ringTone.class);
                    startActivityForResult(jumpActivity, 0);
                }
            });
        }


    }

