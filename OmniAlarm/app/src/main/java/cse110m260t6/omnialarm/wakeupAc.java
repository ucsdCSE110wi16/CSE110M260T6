package cse110m260t6.omnialarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ted on 16/2/22.
 */
public class wakeupAc extends AppCompatActivity{
    Button Choose_wakeup;
    Button Math_problem;
    Button Reverse_String;
    String activity;
    Alarm myAl;
    TextView time;
    TextView ringtone;
    TextView activity_animation;
    static int checkForClick = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wakeup_ac);

        //get the temp alarm from database
        myAl = Database.getTempAlarm();

        time = (TextView)findViewById(R.id.time_string);
        ringtone = (TextView)findViewById(R.id.ringtone_string);
        activity_animation = (TextView)findViewById(R.id.activity_string);

        time.setText(myAl.getTimeString());
        ringtone.setText(myAl.getRingTone());

        //logic for math problem button
        Math_problem = (Button)findViewById(R.id.math);

        Math_problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = "Solve Math Problem";
                myAl.setWake_up_activity(activity);

                activity_animation.setText(activity);
                activity_animation.startAnimation(AnimationUtils.loadAnimation(wakeupAc.this, android.R.anim.slide_in_left));
                checkForClick = 1;
            }
        });

        //logic for reverse string button
        Reverse_String = (Button)findViewById(R.id.reverse);

        Reverse_String.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = "Reverse the String";
                myAl.setWake_up_activity(activity);

                activity_animation.setText(activity);
                activity_animation.startAnimation(AnimationUtils.loadAnimation(wakeupAc.this, android.R.anim.slide_in_left));
                checkForClick = 1;
            }
        });

        //choose_wakeup button logic to put temp alarm into final table in the database
        //and jump back to main page
        Choose_wakeup = (Button)findViewById(R.id.choose_wake_up);

        Choose_wakeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //store the alarm back to the final table
                //Database.insertAlarm(myAl);

                if(checkForClick != 0) {
                    //store the alarm back to the final table
                    Database.insertAlarm(myAl);
                    //jump back to main page
                    Intent jumAc = new Intent(v.getContext(), cse110m260t6.omnialarm.main_ac.class);
                    startActivity(jumAc);
                }
                else{

                    String message = "Please choose an activity";
                    Toast.makeText(wakeupAc.this,message, Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}