package com.elatesoftware.elatesoftwaretemplate.di.components;

import com.elatesoftware.elatesoftwaretemplate.features.authemail.AuthByEmailActivity;
import com.elatesoftware.elatesoftwaretemplate.di.modules.AuthByEmailModule;
import com.elatesoftware.elatesoftwaretemplate.di.scopeannotations.PerActivity;

import dagger.Subcomponent;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

@PerActivity(AuthByEmailActivity.class)
@Subcomponent(modules = AuthByEmailModule.class)
public interface AuthByEmailComponent {

    void inject(AuthByEmailActivity authByEmailActivity);
}

