package com.airwallex.xiangyu.operator;


import com.airwallex.xiangyu.exception.NonSufficientParamException;
import com.airwallex.xiangyu.exception.UnSupportedOperatorExecption;

import java.util.Stack;


public abstract class Operator {

  abstract void calculate(Stack<Double> stack,Stack<String> historyStack)
          throws NonSufficientParamException, UnSupportedOperatorExecption;
  abstract void validateOperand() throws IllegalArgumentException;
  abstract void getOperand(Stack<Double> stack) throws  NonSufficientParamException;

  //Template method pattern
  public final void cal(Stack<Double> stack, Stack<String> historyStack)
          throws IllegalArgumentException, NonSufficientParamException, UnSupportedOperatorExecption {
    getOperand(stack);
    validateOperand();
    calculate(stack,historyStack);
  }
}
