package com.elatesoftware.domain.usecases;

/**
 * Created by Андрей Евтухов on 11.04.2018.
 */

public abstract class BaseUseCase<InParam, OutParam> {

    abstract void execute(OutParam outParam, InParam inParam);
}
