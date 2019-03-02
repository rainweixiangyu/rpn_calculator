package com.airwallex.xiangyu.factory;

import com.airwallex.xiangyu.exception.UnSupportedOperatorExecption;
import com.airwallex.xiangyu.model.OperatorType;
import com.airwallex.xiangyu.operator.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;


public class OperatorFactoryTest {

  @Mock
  OperatorFactory factory;

  @Test
  public void testCreateOperator(){
    factory = new OperatorFactory();

    try {
      OperatorType type = OperatorType.PLUS;
      Operator operator = factory.createOperator(type);
      Assert.assertTrue(operator instanceof PlusOperator);

      type = OperatorType.MINUS;
      operator = factory.createOperator(type);
      Assert.assertTrue(operator instanceof MinusOperator);

      type = OperatorType.MULTIPLY;
      operator = factory.createOperator(type);
      Assert.assertTrue(operator instanceof MultiplyOperator);

      type = OperatorType.DIVIDE;
      operator = factory.createOperator(type);
      Assert.assertTrue(operator instanceof DivideOperator);

      type = OperatorType.CLEAR;
      operator = factory.createOperator(type);
      Assert.assertTrue(operator instanceof ClearOperator);

      type = OperatorType.SQRT;
      operator = factory.createOperator(type);
      Assert.assertTrue(operator instanceof SqrtOperator);

      type = OperatorType.UNDO;
      operator = factory.createOperator(type);
      Assert.assertTrue(operator instanceof UndoOperator);

      type = OperatorType.EXIT;
      operator = factory.createOperator(type);
      Assert.assertTrue(operator instanceof ExitOperator);
    }catch (UnSupportedOperatorExecption e){
      Assert.fail("No exception should be thrown.");
    }
  }
}
