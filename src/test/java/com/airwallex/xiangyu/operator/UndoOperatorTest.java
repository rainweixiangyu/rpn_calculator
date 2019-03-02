package com.airwallex.xiangyu.operator;

import com.airwallex.xiangyu.exception.NonSufficientParamException;
import com.airwallex.xiangyu.model.OperatorType;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Stack;

public class UndoOperatorTest {
  @Mock
  UndoOperator operator;

  @Test
  public void testCal(){
    //Element will be pop if it is a num
    Stack<Double> stack = new Stack<>();
    Double num = 3.14;
    stack.push(num);
    operator = new UndoOperator();
    Stack<String> historyStack = new Stack<>();
    historyStack.push(num.toString());
    try {
      operator.cal(stack,historyStack);
    }catch (Exception e){
      Assert.fail("No exception should be thrown.");
    }
    Assert.assertEquals(0,stack.size());
    Assert.assertEquals(0,historyStack.size());

    //test "+"
    Double result = 100.00;
    stack.clear();
    stack.push(result);
    operator = new UndoOperator();
    Double secOperand = 5.00;
    historyStack.clear();
    historyStack.push(secOperand.toString());
    historyStack.push(OperatorType.PLUS.getName());
    try {
      operator.calculate(stack,historyStack);
    }catch (Exception e){
      Assert.fail("No exception should be thrown.");
    }
    Assert.assertEquals(secOperand,stack.pop(),0.0000001);
    Assert.assertEquals(result-secOperand,stack.pop(),0.0000001);

    //test "-"
    result = 100.00;
    stack.clear();
    stack.push(result);
    operator = new UndoOperator();
    secOperand = 5.00;
    historyStack.clear();
    historyStack.push(secOperand.toString());
    historyStack.push(OperatorType.MINUS.getName());
    try {
      operator.calculate(stack,historyStack);
    }catch (Exception e){
      Assert.fail("No exception should be thrown.");
    }
    Assert.assertEquals(secOperand,stack.pop(),0.0000001);
    Assert.assertEquals(result+secOperand,stack.pop(),0.0000001);

    //test "*"
    result = 100.00;
    stack.clear();
    stack.push(result);
    operator = new UndoOperator();
    secOperand = 5.00;
    historyStack.clear();
    historyStack.push(secOperand.toString());
    historyStack.push(OperatorType.MULTIPLY.getName());
    try {
      operator.calculate(stack,historyStack);
    }catch (Exception e){
      Assert.fail("No exception should be thrown.");
    }
    Assert.assertEquals(secOperand,stack.pop(),0.0000001);
    Assert.assertEquals(result/secOperand,stack.pop(),0.0000001);

    //test "/"
    result = 100.00;
    stack.clear();
    stack.push(result);
    operator = new UndoOperator();
    secOperand = 5.00;
    historyStack.clear();
    historyStack.push(secOperand.toString());
    historyStack.push(OperatorType.DIVIDE.getName());
    try {
      operator.calculate(stack,historyStack);
    }catch (Exception e){
      Assert.fail("No exception should be thrown.");
    }
    Assert.assertEquals(secOperand,stack.pop(),0.0000001);
    Assert.assertEquals(result*secOperand,stack.pop(),0.0000001);

    //test "sqrt"
    result = 100.00;
    stack.clear();
    stack.push(result);
    operator = new UndoOperator();
    historyStack.clear();
    secOperand = 5.00;
    historyStack.push(secOperand.toString());
    historyStack.push(OperatorType.SQRT.getName());
    try {
      operator.calculate(stack,historyStack);
    }catch (Exception e){
      Assert.fail("No exception should be thrown.");
    }
    Assert.assertEquals(result*result,stack.pop(),0.0000001);
  }
}
