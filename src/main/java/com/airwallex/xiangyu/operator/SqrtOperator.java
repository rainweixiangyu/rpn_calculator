package com.airwallex.xiangyu.operator;

import com.airwallex.xiangyu.exception.NonSufficientParamException;
import com.airwallex.xiangyu.model.OperatorType;
import java.util.Stack;

public class SqrtOperator extends Operator {
  private Double opd;

  public Double getOpd() {
    return opd;
  }

  @Override
  public void getOperand(Stack<Double> stack) throws NonSufficientParamException{
    if(stack.size()<1){
      throw new NonSufficientParamException(OperatorType.SQRT.getName());
    }

    this.opd = stack.pop();
  }

  @Override
  public void validateOperand() throws IllegalArgumentException{
    if(this.opd <0){
      throw new IllegalArgumentException("The argument for sqrt should not less than zero.");
    }
  }

  @Override
  public void calculate(Stack<Double> stack, Stack<String> historyStack){
    Double tmp = Math.sqrt(this.opd);
    stack.push(tmp);
  }
}
