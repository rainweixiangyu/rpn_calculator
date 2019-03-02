package com.airwallex.xiangyu.operator;

import com.airwallex.xiangyu.exception.NonSufficientParamException;
import com.airwallex.xiangyu.model.OperatorType;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Stack;

public class SqrtOperatorTest {
  @Mock
  SqrtOperator operator;

  @Test
  public void testGetOperand(){
    //fail:stack must contain at least two nums
    Stack<Double> stack = new Stack<>();
    operator = new SqrtOperator();
    try {
      operator.getOperand(stack);
      Assert.fail("Should throw NonSufficientParamException with message 'sqrt'");
    }catch (NonSufficientParamException e){
      Assert.assertEquals(OperatorType.SQRT.getName(),e.getMessage());
    }

    //correct:get correct operand from stack
    Double operand = 3.14;
    stack.push(operand);
    operator = new SqrtOperator();
    try {
      operator.getOperand(stack);
    }catch (NonSufficientParamException e){
      Assert.fail("No exception should be thrown.");
    }
    Assert.assertEquals(operand,operator.getOpd());
  }

  @Test
  public void testValidateOperand(){
    Stack<Double> stack = new Stack<>();
    Double opd = -3.14;
    stack.push(opd);
    operator = new SqrtOperator();

    try{
      operator.getOperand(stack);
      operator.validateOperand();
      Assert.fail("Should throw IllegalArgumentException.");
    }catch (IllegalArgumentException e){
      Assert.assertEquals("The argument for sqrt should not less than zero.",e.getMessage());
    }catch (NonSufficientParamException e){
      Assert.fail("Should not throw NonSufficientParamException.");
    }
  }

  @Test
  public void testCal(){
    Stack<Double> stack = new Stack<>();
    Double opd = 3.14;
    stack.push(opd);
    operator = new SqrtOperator();
    Stack<String> historyStack = new Stack<>();
    try {
      operator.cal(stack,historyStack);
    }catch (Exception e){
      Assert.fail("No exception should be thrown.");
    }
    Assert.assertEquals((Math.sqrt(opd)),stack.peek().doubleValue(),0.0000001);
  }
}
