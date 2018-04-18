package com.elatesoftware.presentation.di.components;

import com.elatesoftware.presentation.di.modules.DescriptionModule;
import com.elatesoftware.presentation.di.annotations.PerFragment;
import com.elatesoftware.presentation.features.description.DescriptionFragment;

import dagger.Subcomponent;

@PerFragment(DescriptionFragment.class)
@Subcomponent(modules = DescriptionModule.class)
public interface DescriptionComponent {

    void inject(DescriptionFragment fragment);

}

