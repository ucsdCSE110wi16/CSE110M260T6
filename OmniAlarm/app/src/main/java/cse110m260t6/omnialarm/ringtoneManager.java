package cse110m260t6.omnialarm;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by dadongjing on 3/2/16.
 */
public class ringtoneManager {
    static String father = "father";
    static String mermaid = "mermaid";
    static String bc = "bc";
    static MediaPlayer ringtone;

    /*
    public void setRingtone(Context context, String text){
        if(text == father){
            ringtone = MediaPlayer.create(context, R.raw.father);
        }
        if(text == mermaid){
            ringtone = MediaPlayer.create(context, R.raw.mermaid);
        }
        if(text == bc){
            ringtone = MediaPlayer.create(context, R.raw.bc);
        }
    }
*/
    public static void playMusic(Context context, String text){
        if(text.equals(father)){
            ringtone = MediaPlayer.create(context,R.raw.father);
            Log.e("Hey", "father");
        }
        else if(text.equals(mermaid)){
            ringtone = MediaPlayer.create(context,R.raw.mermaid);
            Log.e("Hey", "mermaid");
        }
        else if(text.equals(bc)){
            ringtone = MediaPlayer.create(context,R.raw.bc);
            Log.e("Hey", "bc");
        }
        ringtone.start();
    }

    public static void pauseMusic(){
        ringtone.pause();
    }


}
