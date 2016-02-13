package cse110m260t6.omnialarm;

import android.os.Bundle;
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

        Button add;
        Button choose_music;
        Button choose_wake_method;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.add_alarm);


            //find the button by id
            add = (Button)findViewById(R.id.Add_new_alarm);
            choose_music = (Button)findViewById(R.id.choose_wake_up_music);
            choose_wake_method = (Button)findViewById(R.id.choose_wake_up_method);
            

            add.setOnClickListener(new View.OnClickListener() {
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

                }
            });

        }


    }

