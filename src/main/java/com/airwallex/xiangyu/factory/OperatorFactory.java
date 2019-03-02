package com.airwallex.xiangyu.factory;

import com.airwallex.xiangyu.exception.UnSupportedOperatorExecption;
import com.airwallex.xiangyu.model.OperatorType;
import com.airwallex.xiangyu.operator.*;

public class OperatorFactory extends AbstractFactory{

  @Override
  public Operator createOperator(final OperatorType type) throws UnSupportedOperatorExecption {
    switch (type) {
      case PLUS:
        return new PlusOperator();
      case MINUS:
        return new MinusOperator();
      case MULTIPLY:
        return new MultiplyOperator();
      case DIVIDE:
        return new DivideOperator();
      case SQRT:
        return new SqrtOperator();
      case UNDO:
        return new UndoOperator();
      case CLEAR:
        return new ClearOperator();
      case EXIT:
        return new ExitOperator();
      default:
        throw new UnSupportedOperatorExecption("Operator [" + type.getName() + "] is not supported.");

    }
  }
}
