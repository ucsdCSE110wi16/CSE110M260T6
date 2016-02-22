package cse110m260t6.omnialarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    }
}
