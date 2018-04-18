package com.elatesoftware.presentation.features.main;

import android.view.MenuItem;

import com.arellomobile.mvp.InjectViewState;
import com.elatesoftware.presentation.R;
import com.elatesoftware.presentation.di.Injector;
import com.elatesoftware.presentation.di.annotations.PerActivity;
import com.elatesoftware.presentation.features.base.BasePresenter;
import com.elatesoftware.presentation.features.chat.ChatFragment;
import com.elatesoftware.presentation.features.description.DescriptionFragment;

import javax.inject.Inject;

@PerActivity(MainActivity.class)
@InjectViewState
public class MainPresenter extends BasePresenter<MainView> {

    @Inject
    MainPresenter() { }

    @Override
    public void attachView(MainView view) {
        super.attachView(view);
        getViewState().showFragment(DescriptionFragment.getInstance());
    }

    @Override
    protected void clearComponent() {
        Injector.getInstance().clearMainComponent();
    }

    void onItemSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        switch (menuItem.getItemId()) {
            case R.id.nav_chat:
                getViewState().showFragment(ChatFragment.getInstance());
                break;
            case R.id.nav_description:
                getViewState().showFragment(DescriptionFragment.getInstance());
                break;
        }

    }
}
