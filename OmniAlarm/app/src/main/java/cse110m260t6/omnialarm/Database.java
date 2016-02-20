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
    public static final String DATABASE_NAME = "AlarmData.db";
    public static final String TABLE_NAME = "Settings_Table";
    public static final String COLUMN_0 = "ID";
    public static final String COLUMN_1 = "Time";
    public static final String COLUMN_2 = "Music";
    public static final String COLUMN_3 = "Turn_Off";
    public static final String CREATE_TABLE = "Create table if not exist" +
                                TABLE_NAME + " (" + COLUMN_0 + " INTEGER, " +
                                COLUMN_1 + " TEXT, " + COLUMN_2 +
                                " TEXT, " + COLUMN_3 + " TEXT)";

    public static final int DATABASE_VERSION = 1;

    //create a database
    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //call onCreate() when the database is created for the first time
    //create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop the existent table" + TABLE_NAME);
        onCreate(db);
    }

    //insert settings to table
    public boolean insertSettings(String time, String music, String turnoff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_1, time);
        contentValues.put(COLUMN_2, music);
        contentValues.put(COLUMN_3, turnoff);

        long checking = db.insert(TABLE_NAME, null, contentValues);
        //check if we create a table successfully
        if(checking == -1){
            return false;
        }
        else
            return true;
    }

    public Cursor readSettings(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor settings = db.rawQuery("select * from" + TABLE_NAME, null);
        return settings;
    }

    public boolean updateTime(String id, String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_0, id);
        contentValues.put(COLUMN_3, time);

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{ id });
        return true;
    }

    public boolean updateMusic(String id, String music){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_0, id);
        contentValues.put(COLUMN_3, music);

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }

    public boolean updateTurnOff(String id, String turn_off){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_0, id);
        contentValues.put(COLUMN_3, turn_off);

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }

    public Integer deleteAlarm(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }
}
