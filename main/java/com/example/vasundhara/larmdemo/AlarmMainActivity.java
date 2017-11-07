package com.example.vasundhara.larmdemo;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class AlarmMainActivity extends Activity {
    private TimePicker alarmTimePicker;
    AlarmManager am;
    PendingIntent pendingIntent;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
        alarmTimePicker = (TimePicker) findViewById(R.id.timepicker);
        intent = new Intent(this, AlarmReceiverActivity.class);
        pendingIntent = PendingIntent.getActivity(this, 12345, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        //Create an offset from the current time in which the alarm will go off.
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.SECOND, 5);

        //Create a new PendingIntent and add it to the AlarmManager
//        Intent intent = new Intent(this, AlarmReceiverActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this,
//                12345, intent, PendingIntent.FLAG_CANCEL_CURRENT);
//        AlarmManager am =
//                (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
//        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
//                pendingIntent);
    }

    public void onButtonClicked(View view) {
        Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.SECOND, 5);
        cal.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
        cal.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());

        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                pendingIntent);
        Toast.makeText(this, "Alarm set at " + cal.getTime(), Toast.LENGTH_SHORT).show();
        finish();
//            am.cancel(pendingIntent);
//            Log.d("MyActivity", "Alarm Off");
    }
}