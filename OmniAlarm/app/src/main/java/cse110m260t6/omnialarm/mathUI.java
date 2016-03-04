package cse110m260t6.omnialarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by GING_CHAN on 2/21/2016.
 */
public class mathUI extends AppCompatActivity {

    TextView firstNum;
    TextView secondNum;
    TextView operator;
    ringtoneManager rtm;
    String song;

    EditText input;

    Button checkResult;

    Math_Solve math = new Math_Solve();

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.math_solve);

        //Intent startIntend = getIntent();
        //update the song string based on intend
        //song =

        //create a new ringtone manager
        rtm = new ringtoneManager();
        //set ringtone manager
        //rtm.setRingtone(this,song);

        //rtm.playMusic();

        firstNum = (TextView) findViewById(R.id.first);
        firstNum.setText(math.firstToString());
        secondNum = (TextView) findViewById(R.id.second);
        secondNum.setText(math.secondToString());
        operator = (TextView) findViewById(R.id.operator);
        operator.setText(math.printOperator());


        input = (EditText)findViewById(R.id.inputNum);

        checkResult = (Button)findViewById(R.id.checkResult);

        checkResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checks the user input

                String s = input.getText().toString();
                if (s.equals("")) {
                    checkResult.setText("Incorrect");
                } else {

                    int i = Integer.parseInt(s);

                    if (math.checkAnswer(i)) {
                        //stop the clock?
                        checkResult.setText("Correct");

                        //when user correctly enter the answer, stop the music
                        //rtm.pauseMusic();

                        //jump back to main page
                        Intent backHomePage = new Intent(v.getContext(), cse110m260t6.omnialarm.main_ac.class);
                        startActivity(backHomePage);
                    } else
                        //reset the math???
                        checkResult.setText("Incorrect");
                }
            }
        });
    }




}
