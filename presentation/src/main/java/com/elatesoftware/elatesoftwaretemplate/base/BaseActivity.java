package com.elatesoftware.elatesoftwaretemplate.base;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView{

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
