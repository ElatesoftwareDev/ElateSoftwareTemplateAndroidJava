package com.elatesoftware.elatesoftwaretemplate.authemail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.elatesoftware.elatesoftwaretemplate.R;
import com.elatesoftware.elatesoftwaretemplate.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class AuthByEmailActivity extends BaseActivity implements AuthByEmailView{

    @BindView(R.id.edittext_auth_email_email)
    EditText editTextEmail;
    @BindView(R.id.edit_text_auth_email_password)
    EditText editTextPassword;

    @InjectPresenter
    AuthByEmailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_by_email);
    }

    @OnClick(R.id.button_auth_email_submit)
    void submitButtonClick(){
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        presenter.login(email, password);
    }

}
