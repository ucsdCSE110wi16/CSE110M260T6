package cse110m260t6.omnialarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



/**
 * Created by dadongjing on 2/19/16.
 */
public class ringTone extends AppCompatActivity{

    Button Choose_ringTone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ringtone);


        //find the button by id
        Choose_ringTone = (Button)findViewById(R.id.choose_music);

        //choose ring tone button logic design
        Choose_ringTone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the default alarm from db




                //set the ringtone path to the default alarm




                //put the update default alarm back to database



                //advance to the next page to select wake up activity
                Intent jumAc = new Intent(v.getContext(),cse110m260t6.omnialarm.wakeupAc.class);
                startActivity(jumAc);
            }
        });



    }


}

