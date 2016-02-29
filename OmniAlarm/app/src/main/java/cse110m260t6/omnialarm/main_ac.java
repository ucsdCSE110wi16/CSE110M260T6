package cse110m260t6.omnialarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;

public class main_ac extends AppCompatActivity {

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    TextView time;
    private Context context;
    private List<Alarm> alarmList;
    private Alarm[] alarmEachDate = new Alarm[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // initialize all the textviews
        TextView monday_text = (TextView) findViewById(R.id.monday_time);
        TextView tuesday_text = (TextView) findViewById(R.id.tuesday_time);
        TextView wednesday_text = (TextView) findViewById(R.id.wednesday_time);
        TextView thursday_text = (TextView) findViewById(R.id.thursday_time);
        TextView friday_text = (TextView) findViewById(R.id.friday_time);
        TextView saturday_text = (TextView) findViewById(R.id.saturday_time);
        TextView sunday_text = (TextView) findViewById(R.id.sunday_time);

        // initialize all the buttons
        Button monday = (Button) findViewById(R.id.monday);
        Button tuesday = (Button) findViewById(R.id.tuesday);
        Button wednesday = (Button) findViewById(R.id.wednesday);
        Button thursday = (Button) findViewById(R.id.thursday);
        Button friday = (Button) findViewById(R.id.friday);
        Button saturday = (Button) findViewById(R.id.saturday);
        Button sunday = (Button) findViewById(R.id.sunday);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ac);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.context = this;

        //create a default alarm for future edit
        Alarm myAlarm = new Alarm();

        //initializing database
        Database.init(main_ac.this);

        //store this default alarm in the database
        Database.updateTemp(myAlarm);

        //set alarmManager
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //set intent
        final Intent alarmReceiver = new Intent(this, cse110m260t6.omnialarm.alarmReceiver.class);


        //get all alarm in a list
        alarmList = Database.getAll();

        //iterate all the alarms to get the alarm for each date
        Boolean[] tempAc;
        Alarm tempAlarm;

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

        //setText for each textview
        if(alarmEachDate[0] != null) sunday_text.setText(alarmEachDate[0].getTimeString());
        if(alarmEachDate[1] != null) monday_text.setText(alarmEachDate[1].getTimeString());
        if(alarmEachDate[2] != null) tuesday_text.setText(alarmEachDate[2].getTimeString());
        if(alarmEachDate[3] != null) wednesday_text.setText(alarmEachDate[3].getTimeString());
        if(alarmEachDate[4] != null) thursday_text.setText(alarmEachDate[4].getTimeString());
        if(alarmEachDate[5] != null) friday_text.setText(alarmEachDate[5].getTimeString());
        if(alarmEachDate[6] != null) saturday_text.setText(alarmEachDate[6].getTimeString());

        Button delete = (Button)findViewById(R.id.delete_alarm);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alarm addTem = new Alarm();
                Database.deleteAll();
                Database.updateTemp(addTem);
            }
        });

        /*
        //check final database size
        if(Database.checkForExist() == true){
            //show the final alarm
            Alarm finalAlarm = Database.getAlarm();
            time = (TextView)findViewById(R.id.TV1);
            time.setText(finalAlarm.getTimeString());

            pendingIntent = PendingIntent.getBroadcast(main_ac.this, 0, alarmReceiver, PendingIntent.FLAG_ONE_SHOT);
            alarmManager.set(AlarmManager.RTC_WAKEUP, finalAlarm.getTime().getTimeInMillis(), pendingIntent);


        }*/

        //find the button by id
        Button addAlarm = (Button) findViewById(R.id.addBtn);

        addAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addActivity = new Intent(v.getContext(), cse110m260t6.omnialarm.addAlarm.class);
                startActivity(addActivity);
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_ac, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
