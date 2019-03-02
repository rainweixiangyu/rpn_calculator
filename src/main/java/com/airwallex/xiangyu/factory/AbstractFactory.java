package com.airwallex.xiangyu.factory;

import com.airwallex.xiangyu.exception.UnSupportedOperatorExecption;
import com.airwallex.xiangyu.model.OperatorType;
import com.airwallex.xiangyu.operator.Operator;

public abstract class AbstractFactory {
  public abstract Operator createOperator(final OperatorType type) throws UnSupportedOperatorExecption;
}
