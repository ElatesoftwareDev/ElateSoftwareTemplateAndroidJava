package com.elatesoftware.presentation.features.launch;

import android.content.Intent;

import com.elatesoftware.presentation.features.base.BaseView;

/**
 * Created by Андрей Евтухов on 11.04.2018.
 */

interface LaunchView extends BaseView {

    void startNextActivity(Intent intent);

}
