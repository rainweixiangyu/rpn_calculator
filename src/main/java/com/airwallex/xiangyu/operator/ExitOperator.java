package com.airwallex.xiangyu.operator;

import com.airwallex.xiangyu.model.ExitStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class ExitOperator extends Operator {
  public static Logger log = LoggerFactory.getLogger(ExitOperator.class);

  @Override
  public void getOperand(Stack<Double> stack){

  }

  @Override
  public void validateOperand(){

  }

  @Override
  public void calculate(Stack<Double> stack, Stack<String> historyStack){
    log.info("Calculator exit successfully.");
    System.exit(ExitStatus.NORMAL.getValue());
  }
}
