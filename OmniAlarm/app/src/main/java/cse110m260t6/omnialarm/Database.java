package cse110m260t6.omnialarm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by dadongjing on 2/8/16.
 */
public class Database extends SQLiteOpenHelper{
    static Database database1;
    static SQLiteDatabase database2;

    public static final String DATABASE_NAME = "AlarmData.db";
    public static final String TEMP_TABLE = "Temp_Table";
    public static final String FINAL_TABLE = "Final_Table";
    public static final String COLUMN_0 = "ID";
    public static final String COLUMN_1 = "TIME";
    public static final String COLUMN_2 = "RINGTONE";
    public static final String COLUMN_3 = "ACTIVITY";
    //public static final String CREATE_TABLE = "create table " + " (ID INTEGER PRIMARY KEY,TIME TEXT, RINGTONE TEXT, ACTIVITY TEXT)";


    //public static final String CREATE_TEMP_TABLE = "create table " + " (ID INTEGER PRIMARY KEY,TIME TEXT, RINGTONE TEXT, ACTIVITY TEXT)";


    public static final int DATABASE_VERSION = 1;


    //create a database
    Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static void init(Context context){
        if(database1 == null){
            database1 = new Database(context);
        }
    }

    //call onCreate() when the database is created for the first time
    //create tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS" + FINAL_TABLE + "("
                   + COLUMN_0 + " INTEGER primary key autoincrement, "
                   + COLUMN_1 + " TEXT, "
                   + COLUMN_2 + " TEXT, "
                   + COLUMN_3 + " TEXT)");

        db.execSQL("CREATE TABLE IF NOT EXISTS" + TEMP_TABLE + "("
                   + COLUMN_0 + " INTEGER primary key autoincrement, "
                   + COLUMN_1 + " TEXT, "
                   + COLUMN_2 + " TEXT, "
                   + COLUMN_3 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + FINAL_TABLE);
        db.execSQL("DROP TABLE IF EXISTS" + TEMP_TABLE);

        onCreate(db);
    }
    public static SQLiteDatabase getDataBase(){
        if(database2 == null){
            database2 = database1.getWritableDatabase();
        }
        return database2;
    }
/*
    public boolean insertTempTime(Alarm alarm){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_1, alarm.getTimeString());

        long checking = db.insert(TEMP_TABLE, null, contentValues);
        //check if we create a table successfully
        if(checking == -1){
            return false;
        }
        else
            return true;    }

    public boolean insertTempMusic(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_2, " ");

        long checking = db.insert(TEMP_TABLE, null, contentValues);
        //check if we create a table successfully
        if(checking == -1){
            return false;
        }
        else
            return true;
    }

    public boolean insertTempTurnOff(Alarm alarm){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_3, " ");

        long checking = db.insert(TEMP_TABLE, null, contentValues);
        //check if we create a table successfully
        if(checking == -1){
            return false;
        }
        else
            return true;
    }
*/

    /* update method for temp alarm */
    public static long updateTemp(Alarm alarm){
        //SQLiteDatabase db = getDataBase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_1,alarm.getTimeString());
        contentValues.put(COLUMN_2," ");
        contentValues.put(COLUMN_3," ");

        return getDataBase().insert(TEMP_TABLE, null, contentValues);
        /*
        //check if we create a table successfully
        if(checking == -1){
            return false;
        }
        else
            return true;
            */
    }



    /*insert settings to final table  */
    public static boolean insertAlarm(Alarm alarm){
        SQLiteDatabase db = getDataBase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_1, alarm.getTimeString());
        contentValues.put(COLUMN_2, " ");
        contentValues.put(COLUMN_3, " ");

        long checking = db.insert(FINAL_TABLE, null, contentValues);
        //check if we create a table successfully
        if(checking == -1){
            return false;
        }
        else
            return true;
    }

    /* getter for the actual valid alarm */
    public static Alarm getAlarm(){
        SQLiteDatabase db = getDataBase();
        Cursor alarmCursor = db.rawQuery("select * from" + FINAL_TABLE, null);

        String Time = alarmCursor.getString(1);
        String ringtone = alarmCursor.getString(2);
        String wake_up_activity = alarmCursor.getString(3);
        Alarm returnAlarm = new Alarm(Time,ringtone,wake_up_activity);
        return returnAlarm;
    }

    /* getter for the temp alarm */
    public static Alarm getTempAlarm(){
        SQLiteDatabase db = getDataBase();
        Cursor alarmCursor = db.rawQuery("select * from" + TEMP_TABLE, null);
        String Time = alarmCursor.getString(1);
        String ringtone = alarmCursor.getString(2);
        String wake_up_activity = alarmCursor.getString(3);
        Alarm returnAlarm = new Alarm(Time,ringtone,wake_up_activity);
        return returnAlarm;
    }
/*
    public boolean updateTime(String id, String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_0, id);
        contentValues.put(COLUMN_3, time);

        db.update(FINAL_TABLE, contentValues, "ID = ?", new String[]{ id });
        return true;
    }

    public boolean updateMusic(String id, String music){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_0, id);
        contentValues.put(COLUMN_3, music);

        db.update(FINAL_TABLE, contentValues, "ID = ?", new String[]{id});
        return true;
    }

    public boolean updateTurnOff(String id, String turn_off){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_0, id);
        contentValues.put(COLUMN_3, turn_off);

        db.update(FINAL_TABLE, contentValues, "ID = ?", new String[]{id});
        return true;
    }
*/
    public static Integer deleteAlarm(String id){
        SQLiteDatabase db = getDataBase();
        return db.delete(FINAL_TABLE, "ID = ?", new String[]{id});
    }
}
