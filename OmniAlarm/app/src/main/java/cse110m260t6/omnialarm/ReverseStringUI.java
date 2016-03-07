package cse110m260t6.omnialarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by GING_CHAN on 3/5/2016.
 */
public class ReverseStringUI extends AppCompatActivity {

    TextView sampleString;
    EditText userInput;

    Button checkReverse;

    Reverse_String r = new Reverse_String();

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.reverse);

        sampleString = (TextView) findViewById(R.id.string_prompt);
        sampleString.setText(r.getString());

        userInput = (EditText) findViewById(R.id.input);

        checkReverse = (Button) findViewById(R.id.check);

        checkReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = userInput.getText().toString();

                if(r.checkresult(s)) {
                    //stop the clock
                    checkReverse.setText("nice, you can stop the alarm");
                    //temporary set back to main ui, could be altered later
                    Intent backHomePage = new Intent(v.getContext(),cse110m260t6.omnialarm.main_ac.class);
                    startActivityForResult(backHomePage,0);
                    ringtoneManager.pauseMusic();
                }
                else {
                    checkReverse.setText("wrong input, type again!!");
                }

            }
        });


    }
}
