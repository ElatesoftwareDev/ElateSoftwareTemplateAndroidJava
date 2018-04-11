package com.elatesoftware.data.local;

import com.elatesoftware.data.local.preferences.IPreferencesStorage;

import javax.inject.Inject;

/**
 * Created by Андрей Евтухов on 11.04.2018.
 */

public class Cache {

    private final IPreferencesStorage preferencesStorage;

    @Inject
    Cache(IPreferencesStorage preferencesStorage) {
        this.preferencesStorage = preferencesStorage;
    }

    public String getToken(){
        return preferencesStorage.getToken();
    }

    public void setToken(String token){
        preferencesStorage.setToken(token);
    }
}
