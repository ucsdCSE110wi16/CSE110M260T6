package cse110m260t6.omnialarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by dadongjing on 2/19/16.
 */
public class ringTone extends AppCompatActivity{

    Button Choose_ringTone;
    Button S1;
    Button S2;
    Button S3;
    String songName;
    Alarm myAl;
    TextView Time_animation;
    TextView RingTone_animation;
    TextView Act_animation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ringtone);

        //update all song button
        S1 = (Button)findViewById(R.id.song1);
        S2 = (Button)findViewById(R.id.song2);
        S3 = (Button)findViewById(R.id.song3);
        Time_animation = (TextView)findViewById(R.id.time);
        RingTone_animation = (TextView)findViewById(R.id.ring);
        Act_animation = (TextView)findViewById(R.id.act);



        //get the default alarm from db
        myAl = Database.getTempAlarm();

        Time_animation.setText(myAl.getTimeString());

        /*
        //tell the user to select a ringtone
        String message = "Please select a ringtone";
        Toast.makeText(ringTone.this,message,Toast.LENGTH_LONG);

*/
        //logic for first song button
        S1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songName = "father";
                myAl.setRingTone(songName);
                RingTone_animation.setText(songName);
                RingTone_animation.startAnimation(AnimationUtils.loadAnimation(ringTone.this,android.R.anim.slide_in_left));

            }
        });

        //logic for second song button
        S2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songName = "mermaid";
                myAl.setRingTone(songName);
                RingTone_animation.setText(songName);
                RingTone_animation.startAnimation(AnimationUtils.loadAnimation(ringTone.this, android.R.anim.slide_in_left));

            }
        });

        //logic for third song button
        S3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songName = "bc";
                myAl.setRingTone(songName);
                RingTone_animation.setText(songName);
                RingTone_animation.startAnimation(AnimationUtils.loadAnimation(ringTone.this, android.R.anim.slide_in_left));

            }
        });

        //find the button by id
        Choose_ringTone = (Button)findViewById(R.id.choose_music);

        //choose ring tone button logic design
        Choose_ringTone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //put the update default alarm back to database
                Database.updateTemp(myAl);

                //if user select a ringtone, advance to next page
                if (myAl.getRingTone() != null) {
                    //advance to the next page to select wake up activity
                    Intent jumAc = new Intent(v.getContext(), cse110m260t6.omnialarm.wakeupAc.class);
                    startActivity(jumAc);
                }
                //if user did not select the ringtone, ask the user to select ringtone
                else{
                    Intent jumAc = new Intent(v.getContext(), cse110m260t6.omnialarm.ringTone.class);
                    startActivity(jumAc);
                }
            }
        });



    }


}

