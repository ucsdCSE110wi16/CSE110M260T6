package cse110m260t6.omnialarm;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

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
        if(text == father){
            ringtone = MediaPlayer.create(context,R.raw.father);
        }
        else if(text == mermaid){
            ringtone = MediaPlayer.create(context,R.raw.mermaid);
        }
        else if(text == bc){
            ringtone = MediaPlayer.create(context,R.raw.bc);
        }
        ringtone.start();
    }

    public static void pauseMusic(){
        ringtone.pause();
    }


}
