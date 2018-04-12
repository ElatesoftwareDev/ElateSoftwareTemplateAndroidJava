package com.elatesoftware.domain.usecases.base;


import com.elatesoftware.domain.executor.ExecutionThread;
import com.elatesoftware.domain.executor.PostExecutionThread;
import com.elatesoftware.domain.repository.IRepository;

import io.reactivex.Single;

public abstract class SingleUseCase<InParam, OutParam> extends BaseUseCase {

    protected SingleUseCase(IRepository repository, ExecutionThread threadExecutor, PostExecutionThread postExecutionThread) {
        super(repository, threadExecutor, postExecutionThread);
    }

    abstract Single<OutParam> buildUseCase(InParam param);

    public Single<OutParam> execute(InParam param) {
        return buildUseCase(param)
                .subscribeOn(executionThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler());
    }

}
