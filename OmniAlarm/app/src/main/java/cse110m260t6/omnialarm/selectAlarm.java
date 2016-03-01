package cse110m260t6.omnialarm;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

/**
 * Created by Ted on 16/2/29.
 */
public class selectAlarm extends AppCompatActivity {

    List<Alarm> alarmList;
    private Alarm[] alarmEachDate = new Alarm[7];
    int date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_alarm);

        alarmList = Database.getAll();
        Alarm tempAlarm;
        Intent intent = getIntent();
        date = intent.getIntExtra("Date", -1);

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

        /*
        if(alarmList != null) {
            if(alarmList.get(0) != null) {
                tempAlarm = alarmList.get(0);
                tempAlarm.setDate(1, true);
                Database.updateById(tempAlarm.getIDString(), tempAlarm);
            }
            if(alarmList.get(1) != null) {
                tempAlarm = alarmList.get(1);
                tempAlarm.setDate(2, true);
                Database.updateById(tempAlarm.getIDString(), tempAlarm);
            }
        }


        Intent goback = new Intent(this, cse110m260t6.omnialarm.main_ac.class);
        startActivity(goback);
        */

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

                if(alarmEachDate[date] != null) {
                    alarmEachDate[date].setDate(date, false);
                    Database.updateById(alarmEachDate[date].getIDString(), alarmEachDate[date]);
                }
                alarmList.get(position).setDate(date, true);
                Database.updateById(alarmList.get(position).getIDString(), alarmList.get(position));

                //TextView alarmSpecific = (TextView) alarm.getChildAt(position);

                String message = "You click alarm" + position;
                //show which alarm is selected
                Toast.makeText(selectAlarm.this, message, Toast.LENGTH_LONG).show();

                Intent goback = new Intent(selectAlarm.this, cse110m260t6.omnialarm.main_ac.class);
                startActivity(goback);

            }
        });
    }

}
