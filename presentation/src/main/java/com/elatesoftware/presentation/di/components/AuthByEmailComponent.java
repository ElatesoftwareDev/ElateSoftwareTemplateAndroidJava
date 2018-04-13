package com.elatesoftware.presentation.di.components;

import com.elatesoftware.presentation.features.auth.mail.AuthByEmailActivity;
import com.elatesoftware.presentation.di.modules.AuthByEmailModule;
import com.elatesoftware.presentation.di.scopeannotations.PerActivity;

import dagger.Subcomponent;

@PerActivity(AuthByEmailActivity.class)
@Subcomponent(modules = AuthByEmailModule.class)
public interface AuthByEmailComponent {

    void inject(AuthByEmailActivity activity);
}

