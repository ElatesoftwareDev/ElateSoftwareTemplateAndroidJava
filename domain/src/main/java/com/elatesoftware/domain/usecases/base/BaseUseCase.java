package com.elatesoftware.domain.usecases.base;


import com.elatesoftware.domain.executor.ExecutionThread;
import com.elatesoftware.domain.executor.PostExecutionThread;
import com.elatesoftware.domain.repository.IRepository;

abstract class BaseUseCase {

    protected final IRepository repository;
    final ExecutionThread executionThread;
    final PostExecutionThread postExecutionThread;

    BaseUseCase(IRepository repository, ExecutionThread threadExecutor, PostExecutionThread postExecutionThread) {
        this.repository = repository;
        this.executionThread = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }
}
