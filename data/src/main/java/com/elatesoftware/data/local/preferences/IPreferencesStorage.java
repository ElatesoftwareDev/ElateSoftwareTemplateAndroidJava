package com.elatesoftware.data.local.preferences;

/**
 * Created by Андрей Евтухов on 11.04.2018.
 */

public interface IPreferencesStorage {

    void setToken(String token);
    String getToken();

}
