package cse110m260t6.omnialarm;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;

/**
 * Created by Sylvia on 3/7/2016.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<main_ac> {

    main_ac activity;

    public MainActivityTest() {
        super(main_ac.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    @SmallTest
    public void testButtonsNotNull() {
        Button addAlarmBtn = (Button) activity.findViewById(R.id.addBtn);
        assertNotNull(addAlarmBtn);

        Button deleteAlarmBtn = (Button) activity.findViewById(R.id.delete_alarm);
        assertNotNull(deleteAlarmBtn);

        Button sundayBtn = (Button) activity.findViewById(R.id.sunday);
        assertNotNull(sundayBtn);

        Button mondayBtn = (Button) activity.findViewById(R.id.monday);
        assertNotNull(mondayBtn);

        Button tuesdayBtn = (Button) activity.findViewById(R.id.tuesday);
        assertNotNull(tuesdayBtn);

        Button wednesdayBtn = (Button) activity.findViewById(R.id.wednesday);
        assertNotNull(wednesdayBtn);

        Button thursdayBtn = (Button) activity.findViewById(R.id.thursday);
        assertNotNull(thursdayBtn);

        Button fridayBtn = (Button) activity.findViewById(R.id.friday);
        assertNotNull(fridayBtn);

        Button saturdayBtn = (Button) activity.findViewById(R.id.saturday);
        assertNotNull(saturdayBtn);
    }
}
