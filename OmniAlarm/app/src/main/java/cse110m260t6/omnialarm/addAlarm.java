package cse110m260t6.omnialarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

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
            
            /*
            addAlarm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            */
        }


    }

