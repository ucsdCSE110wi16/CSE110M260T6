package cse110m260t6.omnialarm;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

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

        //register click call back
        registerClickCallBack();
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


    /*private method to register click call back */
    private void registerClickCallBack(){
        //get the list view
        ListView myListView = (ListView)findViewById(R.id.listView);

        //set on item click listener
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClick, int position, long id) {
                //get the textView
                LinearLayout alarm = (LinearLayout) viewClick;

                //TextView alarmSpecific = (TextView) alarm.getChildAt(position);

                String message = "You click alarm" + position;
                //show which alarm is selected
                Toast.makeText(chooseDay.this,message, Toast.LENGTH_LONG).show();

            }
        });
    }

}