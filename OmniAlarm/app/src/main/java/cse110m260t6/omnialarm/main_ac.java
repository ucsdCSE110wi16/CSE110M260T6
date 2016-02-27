package cse110m260t6.omnialarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.nio.channels.AlreadyConnectedException;

public class main_ac extends AppCompatActivity {


    TextView time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ac);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //create a default alarm for future edit
        Alarm myAlarm = new Alarm();

        //initializing database
        Database.init(main_ac.this);

        //store this default alarm in the database
        Database.updateTemp(myAlarm);


        Button delete = (Button)findViewById(R.id.delete_alarm);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alarm addTem = new Alarm();
                Database.deleteAll();
                Database.updateTemp(addTem);
            }
        });

        //check final database size
        if(Database.checkForExist() == true){
            //show the final alarm
            Alarm finalAlarm = Database.getAlarm();
            time = (TextView)findViewById(R.id.TV1);
            time.setText(finalAlarm.getTimeString());

        }

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
