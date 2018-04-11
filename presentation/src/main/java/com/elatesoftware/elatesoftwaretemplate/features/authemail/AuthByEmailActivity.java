package com.elatesoftware.elatesoftwaretemplate.features.authemail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.elatesoftware.elatesoftwaretemplate.R;
import com.elatesoftware.elatesoftwaretemplate.features.base.BaseActivity;
import com.elatesoftware.elatesoftwaretemplate.di.Injector;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.OnClick;

public class AuthByEmailActivity extends BaseActivity implements AuthByEmailView{

    @BindView(R.id.edittext_auth_email_email)
    EditText editTextEmail;
    @BindView(R.id.edit_text_auth_email_password)
    EditText editTextPassword;

    @InjectPresenter
    AuthByEmailPresenter presenter;
    @Inject
    Provider<AuthByEmailPresenter> presenterProvider;

    @ProvidePresenter
    AuthByEmailPresenter providePresenter() {
        return presenterProvider.get();
    }

    public static Intent getActivityIntent(Context context){
        return new Intent(context, AuthByEmailActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_by_email);
    }

    @Override
    protected void injectComponent() {
        Injector.getInstance().plusAuthByEmailComponent().inject(this);
    }

    @OnClick(R.id.button_auth_email_submit)
    void submitButtonClick(){
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        presenter.login(email, password);
    }

}
