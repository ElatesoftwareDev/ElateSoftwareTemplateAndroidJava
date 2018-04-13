package com.elatesoftware.data.threads;

import com.elatesoftware.domain.executor.ExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class JobExecutor implements ExecutionThread {

    @Inject
    JobExecutor() {}

    @Override
    public Scheduler getScheduler() {
        return Schedulers.io();
    }
}
