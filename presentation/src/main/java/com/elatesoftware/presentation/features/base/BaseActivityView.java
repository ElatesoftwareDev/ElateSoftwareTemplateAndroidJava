package com.elatesoftware.presentation.features.base;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface BaseActivityView extends BaseView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void finishActivity();
}
