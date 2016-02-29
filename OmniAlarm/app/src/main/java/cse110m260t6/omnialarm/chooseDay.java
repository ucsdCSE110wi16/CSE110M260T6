package cse110m260t6.omnialarm;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.List;

/**
 * Created by dadongjing on 2/28/16.
 */
public class chooseDay extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_day);

        //populate the list view with alarm
        populateListView();
    }

    /* private method to populate the list view */
    private void populateListView(){
        //get the cursor
        Cursor cursor = Database.get();

        //create its filed
        String[] alarmTime = new String[]{Database.COLUMN_1,Database.COLUMN_2,Database.COLUMN_3};
        int[] timeToView = new int[]{R.id.time,R.id.ringtone,R.id.activity};

        //create the simple cursor adapter
        SimpleCursorAdapter myAdapter = new SimpleCursorAdapter(getBaseContext(),R.layout.time,
                cursor,alarmTime,timeToView,0);
        //create list view
        ListView myListView = (ListView)findViewById(R.id.listView);

        //set adapter
        myListView.setAdapter(myAdapter);


    }

}