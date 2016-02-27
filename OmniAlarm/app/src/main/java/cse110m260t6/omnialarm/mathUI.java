package cse110m260t6.omnialarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by GING_CHAN on 2/21/2016.
 */
public class mathUI extends AppCompatActivity {

    TextView firstNum;
    TextView secondNum;
    TextView operator;


    EditText input;

    Button checkResult;

    Math_Solve math = new Math_Solve();

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.math_solve);

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
                int i = Integer.parseInt(s);

                if(math.checkAnswer(i)){
                    //stop the clock?
                    checkResult.setText("Correct");
                    Intent backHomePage = new Intent(v.getContext(),cse110m260t6.omnialarm.main_ac.class);
                    startActivityForResult(backHomePage,0);
                }
                else
                    //reset the math???
                    checkResult.setText("Incorrect");
            }

        });
    }




}
