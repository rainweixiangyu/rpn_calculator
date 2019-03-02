package com.airwallex.xiangyu.calculator;

import com.airwallex.xiangyu.RpnCalculatorApplication;
import com.airwallex.xiangyu.exception.NonSufficientParamException;
import com.airwallex.xiangyu.exception.UnSupportedOperatorExecption;
import com.airwallex.xiangyu.factory.AbstractFactory;
import com.airwallex.xiangyu.factory.OperatorFactory;
import com.airwallex.xiangyu.model.ExitStatus;
import com.airwallex.xiangyu.model.OperatorType;
import com.airwallex.xiangyu.operator.Operator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static com.airwallex.xiangyu.util.DisplayInfoUtil.*;
import static com.airwallex.xiangyu.util.DisplayInfoUtil.displayInputHint;
import static com.airwallex.xiangyu.util.InputAnalysisUtil.isNumber;
import static com.airwallex.xiangyu.util.StackUtil.outputStackContent;

public class RPNCalculator extends Calculator {
  public static Logger log = LoggerFactory.getLogger(RPNCalculator.class);

  private Stack<Double> stack;
  private Stack<String> historyStack;
  private AbstractFactory factory;

  public RPNCalculator(){
    stack = new Stack<Double>();
    historyStack = new Stack<String>();
    factory = new OperatorFactory();
    displayWelcomeInfo();
  }

  @Override
  public void calculate(){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = null;
    int pos;
    try {
      displayInputHint();
      while ((line = br.readLine()) != null){
        pos = 0;
        String[] inputArray = line.split("[\\s]+");
        for(String input : inputArray){
          input.trim();
          pos++;
          if(isNumber(input)){
            stack.push(Double.parseDouble(input));
          }else{
            try {
              OperatorType type = OperatorType.from(input.toLowerCase());
              Operator operator = factory.createOperator(type);
              operator.cal(stack,historyStack);
            }catch (UnSupportedOperatorExecption e){
              log.error("Operator [{}] is not supported.Exception:{}.",input,e.getMessage());
              outputStackContent(stack);
              System.exit(ExitStatus.OPERATOR_ERROR.getValue());
            }catch(IllegalArgumentException e){
              log.error("Operand for operator [{}] is not illegal.Exception:{}.",input,e.getMessage());
              outputStackContent(stack);
              System.exit(ExitStatus.OPERAND_ERROR.getValue());
            }catch (NonSufficientParamException e){
              System.out.println("operator "+input+" (position: "+(pos*2-1)+"): insufficient parameters");
              outputStackContent(stack);
              displayNonSufficientInfo(inputArray,pos);
              log.error("Operand is not sufficient for operator[{}].Exception:{}.",input,e.getMessage());
              System.exit(ExitStatus.PARAM_ERROR.getValue());
            }
          }
          if(!input.equals(OperatorType.UNDO.getName()) && !input.equals(OperatorType.CLEAR.getName())){
            historyStack.push(input);
          }
        }
        outputStackContent(stack);
        displayInputHint();
      }
    } catch (IOException e) {
      log.error("IOException happens when read input from command line. Exception:{}",e.toString());
      outputStackContent(stack);
      System.exit(ExitStatus.IO_ERROR.getValue());
    }
  }
}
