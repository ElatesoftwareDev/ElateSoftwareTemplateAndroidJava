package com.elatesoftware.domain.usecases.base;


import com.elatesoftware.domain.executor.ExecutionThread;
import com.elatesoftware.domain.executor.PostExecutionThread;
import com.elatesoftware.domain.repository.IRepository;

import io.reactivex.Flowable;

public abstract class FlowableUseCase<InParam, OutParam> extends BaseUseCase {

    protected FlowableUseCase(IRepository repository, ExecutionThread threadExecutor, PostExecutionThread postExecutionThread) {
        super(repository, threadExecutor, postExecutionThread);
    }

    protected abstract Flowable<OutParam> buildUseCase(InParam param);

    public Flowable<OutParam> execute(InParam param) {
        return buildUseCase(param)
                .subscribeOn(executionThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler());
    }
}
