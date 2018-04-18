package com.elatesoftware.presentation.features.description;

import com.arellomobile.mvp.InjectViewState;
import com.elatesoftware.presentation.di.Injector;
import com.elatesoftware.presentation.di.annotations.PerFragment;
import com.elatesoftware.presentation.features.base.BasePresenter;

import javax.inject.Inject;

@InjectViewState
@PerFragment(DescriptionFragment.class)
public class DescriptionPresenter extends BasePresenter<DescriptionView> {

    @Inject
    DescriptionPresenter() { }

    @Override
    protected void clearComponent() {
        Injector.getInstance().clearDescriptionComponent();
    }
}
