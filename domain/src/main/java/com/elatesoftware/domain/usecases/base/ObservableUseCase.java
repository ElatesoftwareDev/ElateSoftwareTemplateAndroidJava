package com.elatesoftware.domain.usecases.base;


import com.elatesoftware.domain.executor.ExecutionThread;
import com.elatesoftware.domain.executor.PostExecutionThread;
import com.elatesoftware.domain.repository.IRepository;

import io.reactivex.Observable;

public abstract class ObservableUseCase<InParam, OutParam> extends BaseUseCase {

    protected ObservableUseCase(IRepository repository, ExecutionThread threadExecutor, PostExecutionThread postExecutionThread) {
        super(repository, threadExecutor, postExecutionThread);
    }

    abstract Observable<OutParam> buildUseCase(InParam param);

    public Observable<OutParam> execute(InParam param) {
        return buildUseCase(param)
                .subscribeOn(executionThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler());
    }

}
