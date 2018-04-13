package com.elatesoftware.domain.usecases;

import com.elatesoftware.domain.executor.ExecutionThread;
import com.elatesoftware.domain.executor.PostExecutionThread;
import com.elatesoftware.domain.repository.IRepository;
import com.elatesoftware.domain.usecases.base.CompletableUseCase;

import javax.inject.Inject;

import io.reactivex.Completable;


public class AuthorizationUseCase extends CompletableUseCase<AuthorizationUseCase.AuthorizationData> {

    @Inject
    AuthorizationUseCase(IRepository repository, ExecutionThread executionThread, PostExecutionThread postExecutionThread) {
        super(repository, executionThread, postExecutionThread);
    }

    @Override
    protected Completable buildUseCase(AuthorizationUseCase.AuthorizationData params) {
        return repository.login(params.getEmail(), params.getPassword());
    }

    public static final class AuthorizationData {
        private final String email;
        private final String password;

        public AuthorizationData(String email, String password) {
            this.email = email;
            this.password = password;
        }

        String getEmail() {
            return email;
        }

        String getPassword() {
            return password;
        }
    }

}
