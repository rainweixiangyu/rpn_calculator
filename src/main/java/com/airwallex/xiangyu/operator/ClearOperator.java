package com.airwallex.xiangyu.operator;

import lombok.Data;

import java.util.Stack;

@Data
public class ClearOperator extends Operator {

  @Override
  public void getOperand(Stack<Double> stack){

  }

  @Override
  public void validateOperand(){

  }

  @Override
  public void calculate(Stack<Double> stack, Stack<String> historyStack){
    stack.clear();
  }
}
