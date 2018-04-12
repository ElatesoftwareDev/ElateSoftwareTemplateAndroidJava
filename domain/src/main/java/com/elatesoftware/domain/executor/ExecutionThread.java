package com.elatesoftware.domain.executor;

import io.reactivex.Scheduler;

public interface ExecutionThread {
    Scheduler getScheduler();
}
