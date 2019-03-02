package com.airwallex.xiangyu.operator;

import com.airwallex.xiangyu.exception.NonSufficientParamException;
import com.airwallex.xiangyu.model.OperatorType;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Stack;

public class MinusOperatorTest {
  @Mock
  MinusOperator operator;

  @Test
  public void testGetOperand(){
    //fail:stack must contain at least two nums
    Stack<Double> stack = new Stack<>();
    operator = new MinusOperator();
    try {
      operator.getOperand(stack);
      Assert.fail("Should throw NonSufficientParamException with message '-'");
    }catch (NonSufficientParamException e){
      Assert.assertEquals(OperatorType.MINUS.getName(),e.getMessage());
    }

    //correct:get correct operand from stack
    Double first = 3.14;
    Double second = 2.35;
    stack.push(first);
    stack.push(second);
    operator = new MinusOperator();
    try {
      operator.getOperand(stack);
    }catch (NonSufficientParamException e){
      Assert.fail("No exception should be thrown.");
    }
    Assert.assertEquals(first,operator.getFirstOperand());
    Assert.assertEquals(second,operator.getSecondOperand());
  }

  @Test
  public void testCal(){
    Stack<Double> stack = new Stack<>();
    Double first = 3.14;
    Double second = 2.35;
    stack.push(first);
    stack.push(second);
    operator = new MinusOperator();
    Stack<String> historyStack = new Stack<>();
    try {
      operator.cal(stack,historyStack);
    }catch (Exception e){
      Assert.fail("No exception should be thrown.");
    }
    Assert.assertEquals((first.doubleValue()-second.doubleValue()),stack.peek().doubleValue(),0.0000001);
  }
}
