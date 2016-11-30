package io.skipday.keepalive.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.skipday.keepalive.R;
import io.skipday.keepalive.mvp.MainMvp;
import io.skipday.keepalive.preference.Preferences;
import io.skipday.keepalive.presenters.MainPresenter;

/**
 * Created by jagamypriera on 28/11/16.
 */

public class AnotherMainActivity extends AppCompatActivity implements MainMvp.PingMvp, CompoundButton.OnCheckedChangeListener {
    private MainPresenter presenter;
    @Bind(R.id.toggleButton)
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_main_activity);
       ButterKnife.bind(this);
        presenter = new MainPresenter();
        presenter.attachView(this);
        Log.e("Asdf",""+Preferences.with(AnotherMainActivity.this).getStatus());
        toggleButton.setOnCheckedChangeListener(this);
        if (Preferences.with(AnotherMainActivity.this).getStatus().equals("0")) {
            toggleButton.setChecked(false);
        } else {
            toggleButton.setChecked(true);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.get("http://192.168.1.11/api_next.lc?action=lamp_status");

    }

    @Override
    public void onSuccess(String response) {
        Log.e("Asdf",""+response);
        if (response.equals("1") || response.equals("HIGH")) {
            //toggleButton.setChecked(true);
            Preferences.with(AnotherMainActivity.this).setStatus("0").save();
        } else if (response.equals("0") || response.equals("LOW")){
            Preferences.with(AnotherMainActivity.this).setStatus("1").save();
            //toggleButton.setChecked(false);
        }
    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Log.e("Asdf",""+toggleButton.isChecked());
        if (toggleButton.isChecked()) {
            presenter.get("http://192.168.1.11/api_next.lc?action=turn_on_lamp");
        } else {
            presenter.get("http://192.168.1.11/api_next.lc?action=turn_off_lamp");
        }
    }
}
