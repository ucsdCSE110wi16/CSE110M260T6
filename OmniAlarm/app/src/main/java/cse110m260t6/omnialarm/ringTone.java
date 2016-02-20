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
        Choose_ringTone = (Button)findViewById(R.id.Choose_time);

        /* choose ring tone button logic design */
        Choose_ringTone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });



    }


}

