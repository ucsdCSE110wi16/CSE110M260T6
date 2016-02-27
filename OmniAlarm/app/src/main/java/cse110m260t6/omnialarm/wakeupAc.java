package cse110m260t6.omnialarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ted on 16/2/22.
 */
public class wakeupAc extends AppCompatActivity{
    Button Choose_wakeup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wakeup_ac);

        Choose_wakeup = (Button)findViewById(R.id.choose_wake_up);

        Choose_wakeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumAc = new Intent(v.getContext(),cse110m260t6.omnialarm.main_ac.class);
                startActivity(jumAc);
            }
        });
    }
}
