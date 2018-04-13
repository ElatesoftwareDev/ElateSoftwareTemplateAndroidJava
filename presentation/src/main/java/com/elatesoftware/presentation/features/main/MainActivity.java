package com.elatesoftware.presentation.features.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.elatesoftware.presentation.R;
import com.elatesoftware.presentation.di.Injector;
import com.elatesoftware.presentation.features.base.BaseActivity;

/**
 * Created by Андрей Евтухов on 13.04.2018.
 */

public class MainActivity extends BaseActivity implements MainView {

    public static Intent getActivityIntent(Context context){
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void injectComponent() {
        Injector.getInstance().plusMainComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
