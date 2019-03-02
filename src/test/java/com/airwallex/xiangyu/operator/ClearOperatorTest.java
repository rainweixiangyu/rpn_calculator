package com.airwallex.xiangyu.operator;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Stack;

public class ClearOperatorTest {

  @Mock
  ClearOperator operator;

  @Test
  public void testCal(){
    Stack<Double> stack = new Stack<>();
    Double first = 3.14;
    Double second = 2.35;
    stack.push(first);
    stack.push(second);
    operator = new ClearOperator();
    Stack<String> historyStack = new Stack<>();
    try {
      operator.cal(stack,historyStack);
    }catch (Exception e){
      Assert.fail("No exception should be thrown.");
    }
    Assert.assertEquals(0,stack.size());
  }
}
