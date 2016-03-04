package cse110m260t6.omnialarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.sql.DatabaseMetaData;

/**
 * Created by Ted on 16/2/28.
 */
public class alarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("In receiver", "yay");

        String id = intent.getStringExtra("id");
        Alarm myAl = Database.getByID(id);

        String activity = myAl.getWake_up_activity();

        String ringtone = myAl.getRingTone();

        ringtoneManager.playMusic(context, ringtone);

        if(activity.equals("Solve Math Problem")) {

            //start new activity
            Intent jumpToMath = new Intent(context, cse110m260t6.omnialarm.mathUI.class);

            //update its flag
            jumpToMath.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //jump to solve_math_for wake up activity
            context.startActivity(jumpToMath);
        }
    }
}
