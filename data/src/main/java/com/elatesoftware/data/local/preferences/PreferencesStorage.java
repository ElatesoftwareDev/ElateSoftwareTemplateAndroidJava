package com.elatesoftware.data.local.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by Андрей Евтухов on 11.04.2018.
 */

public class PreferencesStorage implements IPreferencesStorage {

    private static final String PREFERENCES_APP = "com.elatesoftware.template.PREFERENCES_APP";

    private static final String PREFERENCE_TOKEN = "PREFERENCE_TOKEN";

    private final SharedPreferences pref;

    @Inject
    PreferencesStorage(Context context) {
        pref = context.getSharedPreferences(PREFERENCES_APP, Context.MODE_PRIVATE);
    }

    @Override
    public void setToken(String token) {
        pref.edit()
                .putString(PREFERENCE_TOKEN, token)
                .apply();
    }

    @Override
    public String getToken() {
        return pref
                .getString(PREFERENCE_TOKEN, null);
    }
}
