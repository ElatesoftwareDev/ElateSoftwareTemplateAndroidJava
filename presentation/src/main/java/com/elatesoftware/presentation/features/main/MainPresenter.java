package com.elatesoftware.presentation.features.main;

import android.support.v4.app.FragmentManager;
import android.view.MenuItem;

import com.arellomobile.mvp.InjectViewState;
import com.elatesoftware.presentation.R;
import com.elatesoftware.presentation.di.Injector;
import com.elatesoftware.presentation.di.scopeannotations.PerActivity;
import com.elatesoftware.presentation.features.base.BasePresenter;
import com.elatesoftware.presentation.features.chat.ChatFragment;

import javax.inject.Inject;

@PerActivity(MainActivity.class)
@InjectViewState
public class MainPresenter extends BasePresenter<MainView> {

    @Inject
    MainPresenter() { }

    @Override
    public void attachView(MainView view) {
        super.attachView(view);
        getViewState().showFragment(ChatFragment.getInstance());
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
        }

    }
}
