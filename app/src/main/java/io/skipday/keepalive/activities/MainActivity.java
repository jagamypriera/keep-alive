package io.skipday.keepalive.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.skipday.keepalive.R;
import io.skipday.keepalive.preference.Preferences;

public class MainActivity extends AppCompatActivity implements PreferenceChangeListener{

    SampleAlarmReceiver alarm = new SampleAlarmReceiver();
    @Bind(R.id.input_url)EditText input;
    @Bind(R.id.input_interval)EditText interval;
    @Bind(R.id.log)TextView log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // Menu options to set and cancel the alarm.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // When the user clicks START ALARM, set the alarm.
            case R.id.start_action:
                alarm.setAlarm(this);
                return true;
            // When the user clicks CANCEL ALARM, cancel the alarm.
            case R.id.cancel_action:
                alarm.cancelAlarm(this);
                return true;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
    @OnClick(R.id.btn_send)
    void send(){
        Preferences.with(this).setUrl(input.getText().toString()).save();
        Preferences.with(this).setInterval(Integer.parseInt(interval.getText().toString())).save();
        alarm.setAlarm(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        log.setText(Preferences.with(this).getLog());
    }

    @Override
    public void preferenceChange(PreferenceChangeEvent pce) {
        log.setText(Preferences.with(this).getLog());
    }
}
