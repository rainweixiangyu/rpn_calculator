package com.airwallex.xiangyu.operator;

import com.airwallex.xiangyu.exception.NonSufficientParamException;
import com.airwallex.xiangyu.exception.UnSupportedOperatorExecption;
import com.airwallex.xiangyu.model.OperatorType;

import java.util.EmptyStackException;
import java.util.Stack;

import static com.airwallex.xiangyu.util.InputAnalysisUtil.isNumber;

public class UndoOperator extends Operator {

  @Override
  public void getOperand(Stack<Double> stack){

  }

  @Override
  public void validateOperand(){

  }

  @Override
  public void calculate(Stack<Double> stack, Stack<String> historyStack)
          throws NonSufficientParamException,UnSupportedOperatorExecption{
    try {
      String latest = historyStack.peek();
      if(isNumber(latest)){
        historyStack.pop();
        stack.pop();
      }else{
        OperatorType operator = OperatorType.from(historyStack.pop());
        Double result = stack.pop();
        Double secondOperand;
        switch (operator){
          case PLUS:
            secondOperand = Double.parseDouble(historyStack.peek());
            stack.push(result-secondOperand);
            stack.push(secondOperand);
            break;
          case MINUS:
            secondOperand = Double.parseDouble(historyStack.peek());
            stack.push(result+secondOperand);
            stack.push(secondOperand);
            break;
          case MULTIPLY:
            secondOperand = Double.parseDouble(historyStack.peek());
            stack.push(result/secondOperand);
            stack.push(secondOperand);
            break;
          case DIVIDE:
            secondOperand = Double.parseDouble(historyStack.peek());
            stack.push(result*secondOperand);
            stack.push(secondOperand);
            break;
          case SQRT:
            stack.push(result*result);
            break;
          default:
            throw new UnSupportedOperatorExecption("Operator ["+operator.getName()+"] is not supported in undo.");
        }
      }
    }catch (EmptyStackException e){
      throw new NonSufficientParamException("No element in stack or historyStack for undo operation.");
    }
  }
}
