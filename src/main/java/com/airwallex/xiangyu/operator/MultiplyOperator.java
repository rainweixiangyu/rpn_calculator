package com.airwallex.xiangyu.operator;

import com.airwallex.xiangyu.exception.NonSufficientParamException;
import com.airwallex.xiangyu.model.OperatorType;
import java.util.Stack;


public class MultiplyOperator extends Operator {
  private Double firstOperand;
  private Double secondOperand;

  public Double getFirstOperand() {
    return firstOperand;
  }

  public Double getSecondOperand() {
    return secondOperand;
  }

  @Override
  public void getOperand(Stack<Double> stack) throws NonSufficientParamException{
    if(stack.size()<2){
      throw new NonSufficientParamException(OperatorType.MULTIPLY.getName());
    }

    this.secondOperand = stack.pop();
    this.firstOperand = stack.pop();
  }

  @Override
  public void validateOperand(){

  }

  @Override
  public void calculate(Stack<Double> stack, Stack<String> historyStack){
    Double tmp = this.firstOperand * this.secondOperand;
    stack.push(tmp);
  }
}
