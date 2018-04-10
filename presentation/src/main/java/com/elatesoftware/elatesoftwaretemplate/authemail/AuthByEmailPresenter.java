package com.elatesoftware.elatesoftwaretemplate.authemail;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.elatesoftware.domain.interactors.AuthorizationInteractor;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

@InjectViewState
public class AuthByEmailPresenter extends MvpPresenter<AuthByEmailView> {

    private final AuthorizationInteractor interactor;

    public AuthByEmailPresenter(AuthorizationInteractor interactor) {
        this.interactor = interactor;
    }

    void login(String email, String password){
        if(validateFields(email, password)){
            interactor.login(email, password).subscribe(s -> onSuccessLogin());
        }
    }

    private boolean validateFields(String email, String password) {
        return true;
    }

    private void onSuccessLogin(){
        getViewState().showToast("Успешный успех");
    }

}
