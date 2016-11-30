package io.skipday.keepalive.preference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jagamypriera on 02/03/16.
 */
public class PreferencesList {
    private final SharedPreferences prefs;
    private final SharedPreferences.Editor editor;

    public PreferencesList(Context context) {
        prefs = context.getSharedPreferences("Mangas", Context.MODE_PRIVATE);
        editor = context.getSharedPreferences("Mangas", Context.MODE_PRIVATE).edit();
    }

    public String getGcm() {
        return prefs.getString("gcm", "");
    }

    public PreferencesList setUrl(String url) {
        editor.putString("url", url);
        return this;
    }
    public String getUrl() {
        return prefs.getString("url", "");
    }
    public PreferencesList setLog(String log) {
        editor.putString("log", log);
        return this;
    }
    public String getLog() {
        return prefs.getString("log", "");
    }


    public PreferencesList setInterval(int interval) {
        editor.putInt("interval", interval);
        return this;
    }
    public int getInterval() {
        return prefs.getInt("interval", 1);
    }

    public PreferencesList setGcm(String gcm) {
        editor.putString("gcm", gcm);
        return this;
    }
    public String getName() {
        return prefs.getString("name", "");
    }

    public PreferencesList setName(String name) {
        editor.putString("name", name);
        return this;
    }
    public String getId() {
        return prefs.getString("id", "");
    }

    public PreferencesList setId(String id) {
        editor.putString("id", id);
        return this;
    }
    public String getJabatan() {
        return prefs.getString("jabatan", "");
    }

    public PreferencesList setJabatan(String jabatan) {
        editor.putString("jabatan", jabatan);
        return this;
    }
    public String getUnitKerja() {
        return prefs.getString("unit", "");
    }

    public PreferencesList setUnitKerja(String unitKerja) {
        editor.putString("unit", unitKerja);
        return this;
    }
    public PreferencesList clearAll() {
        editor.clear();
        return this;
    }

    public boolean getSignIn() {
        return prefs.getBoolean("sign", false);
    }

    public PreferencesList setSignIn(boolean signIn) {
        editor.putBoolean("sign", signIn);
        return this;
    }
    public String getPassword() {
        return prefs.getString("password", "");
    }


    public PreferencesList setPassword(String password) {
        editor.putString("password", password);
        return this;
    }

    public String getUserName() {
        return prefs
                .getString("user_name", "");
    }


    public PreferencesList setUserName(String userName) {
        editor.putString("user_name", userName);
        return this;
    }
    public int getDisposisi() {
        return prefs.getInt("disposisi",0);
    }

    public PreferencesList setDisposisi(int disposisi) {
        editor.putInt("disposisi", disposisi);
        return this;
    }

    public String getStatus() {
        return prefs.getString("last_status", "0");
    }

    public PreferencesList setStatus(String status) {
        editor.putString("last_status", status);
        return this;
    }

    public int getPreview() {
        return prefs.getInt("review",0);
    }

    public PreferencesList setPreview(int preview) {
        editor.putInt("review", preview);
        return this;
    }
    public void save() {
        editor.apply();
    }
}
