package cse110m260t6.omnialarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Ted on 16/2/28.
 */
public class alarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("FCK","U");
        //Intent jumpToMath = new Intent(context, cse110m260t6.omnialarm.mathUI.class);
        //context.startActivity(jumpToMath);

    }
}
