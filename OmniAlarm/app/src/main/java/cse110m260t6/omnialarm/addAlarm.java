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
 * Test push by Jinhua Chen
 */
public class addAlarm extends AppCompatActivity{

        Button choose_time;
        /*
        Button choose_music;
        Button choose_wake_method;
        */
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.add_alarm);


            //find the button by id
            choose_time = (Button)findViewById(R.id.Choose_time);
            //choose_music = (Button)findViewById(R.id.choose_wake_up_music);
            //choose_wake_method = (Button)findViewById(R.id.choose_wake_up_method);
            
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
                    System.err.print(hour);
                    System.err.print(minute);
                    */
                    Calendar myCa = Calendar.getInstance();
                    //myCa.set(0,0,0,hour,minute);
                    Alarm myAlarm = new Alarm(myCa);



                    //jump to next page that prompt user to enter ring tone
                    Intent addActivity = new Intent(v.getContext(), cse110m260t6.omnialarm.ringTone.class);
                    startActivityForResult(addActivity, 0);
                }
            });

            /* choose_music button logic design
            choose_music.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
                */

        }


    }

