package com.elatesoftware.presentation.features.launch;

import android.content.Intent;

import com.elatesoftware.presentation.features.base.BaseView;

interface LaunchView extends BaseView {

    void startNextActivity(Intent intent);

}
