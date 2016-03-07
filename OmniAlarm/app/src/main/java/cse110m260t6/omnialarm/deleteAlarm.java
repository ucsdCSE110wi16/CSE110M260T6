package cse110m260t6.omnialarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Ted on 16/3/7.
 */
public class deleteAlarm extends AppCompatActivity {

    List<Alarm> alarmList;
    private Alarm[] alarmEachDate = new Alarm[7];

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_alarm);

        alarmList = Database.getAll();
        Alarm tempAlarm;

        //initialize the alarmList
        Boolean[] tempAc;

        int i;
        int j;
        i = 0;
        while(i < alarmList.size()) {
            tempAlarm = alarmList.get(i);
            tempAc = tempAlarm.getDate();
            for(j = 0; j < 7; j++) {
                if(tempAc[j]) {
                    alarmEachDate[j] = tempAlarm;
                }
            }
            i++;
        }

        back = (Button)findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goback = new Intent(deleteAlarm.this, cse110m260t6.omnialarm.main_ac.class);
                startActivity(goback);
            }
        });
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

                Database.deleteAlarm(alarmList.get(position).getIDString());

                String message = "Alarm " + position + " deleted";
                //show which alarm is selected
                Toast.makeText(deleteAlarm.this, message, Toast.LENGTH_LONG).show();

                Intent delete = new Intent(getBaseContext(), cse110m260t6.omnialarm.deleteAlarm.class);
                startActivity(delete);
            }
        });
    }
}
