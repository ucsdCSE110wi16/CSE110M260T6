package cse110m260t6.omnialarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
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
 * Created by Ted on 16/2/29.
 */
public class selectAlarm extends AppCompatActivity {

    AlarmManager alarmManager;
    List<Alarm> alarmList;
    private Alarm[] alarmEachDate = new Alarm[7];
    private Intent[] alarmReceiver = new Intent[7];
    private PendingIntent pendingIntent;
    private int[] dayOfWeek = new int[] {Calendar.SUNDAY, Calendar.MONDAY, Calendar.TUESDAY,
            Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY,
            Calendar.SATURDAY};

    int date;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_alarm);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmList = Database.getAll();
        Alarm tempAlarm;
        Intent intent = getIntent();
        date = intent.getIntExtra("Date", -1);

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

        //initialize the alarmReceiver
        for(i = 0; i < 7; i++) {
            //input id as action name
            alarmReceiver[i] = new Intent(""+i, null, this, cse110m260t6.omnialarm.alarmReceiver.class);
            if(alarmEachDate[i] != null) alarmReceiver[i].putExtra("id", alarmEachDate[i].getIDString());
        }


        back = (Button)findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goback = new Intent(selectAlarm.this, cse110m260t6.omnialarm.main_ac.class);
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
                LinearLayout alarm = (LinearLayout) viewClick;
                Alarm tempAlarm = alarmList.get(position);
                long intervalMillis = alarmManager.INTERVAL_DAY * 7;

                //update the database
                if(alarmEachDate[date] != null) {
                    alarmEachDate[date].setDate(date, false);
                    Database.updateById(alarmEachDate[date].getIDString(), alarmEachDate[date]);
                }
                tempAlarm.setDate(date, true);
                Database.updateById(tempAlarm.getIDString(), tempAlarm);

                //update alarmManager
                //overwrite the id extra
                alarmReceiver[date].putExtra("id", tempAlarm.getIDString());
                //create the same pendingIntent
                pendingIntent = PendingIntent.getBroadcast(getBaseContext(), 0, alarmReceiver[date], PendingIntent.FLAG_ONE_SHOT);
                //cancel the previous alarm in alarmManager with the same intent
                alarmManager.cancel(pendingIntent);
                //set the new alarm
                Calendar tempCal = Calendar.getInstance();
                Log.e("Current time", tempCal.toString());
                Log.e("Alarm time--", tempAlarm.getTime().toString());
                tempCal.add(Calendar.DAY_OF_WEEK, dayOfWeek[date] - tempCal.get(Calendar.DAY_OF_WEEK));
                Log.e("Updated time", tempCal.toString());
                if(tempCal.get(Calendar.DAY_OF_YEAR) < tempAlarm.getTime().get(Calendar.DAY_OF_YEAR)) {
                    tempCal.add(Calendar.DATE, 7);
                }
                if(tempCal.get(Calendar.DAY_OF_YEAR) == tempAlarm.getTime().get(Calendar.DAY_OF_YEAR) &&
                        tempCal.compareTo(tempAlarm.getTime()) > 0) {
                    tempCal.add(Calendar.DATE, 7);
                }
                tempCal.set(Calendar.HOUR_OF_DAY, tempAlarm.getTime().get(Calendar.HOUR_OF_DAY));
                tempCal.set(Calendar.MINUTE, tempAlarm.getTime().get(Calendar.MINUTE));
                tempCal.set(Calendar.SECOND, 0);
                tempCal.set(Calendar.MILLISECOND, 0);
                Log.e("Final time--", tempCal.toString());

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, tempCal.getTimeInMillis(), intervalMillis, pendingIntent);

                //TextView alarmSpecific = (TextView) alarm.getChildAt(position);

                String message = "You click alarm" + position;
                //show which alarm is selected
                Toast.makeText(selectAlarm.this, message, Toast.LENGTH_LONG).show();

            }
        });
    }

}
