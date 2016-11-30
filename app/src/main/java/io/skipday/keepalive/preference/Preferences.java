package io.skipday.keepalive.preference;

import android.content.Context;

/**
 * Created by jagamypriera on 31/01/16.
 */

public class Preferences {
    private static PreferencesList obj = null;

    public static PreferencesList with(Context context) {
        if (obj == null) {
            obj = new PreferencesList(context);
        }
        return obj;
    }
}
