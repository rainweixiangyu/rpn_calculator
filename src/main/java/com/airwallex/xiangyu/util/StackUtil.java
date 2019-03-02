package com.airwallex.xiangyu.util;

import java.text.DecimalFormat;
import java.util.Stack;

public class StackUtil {
  public static void outputStackContent(Stack<Double> stack){
    Double[] content = new Double[stack.size()];
    stack.copyInto(content);

    DecimalFormat format = new DecimalFormat("#.##########");
    StringBuilder builder = new StringBuilder();
    builder.append("stack:");
    for(Double ele : content){
      builder.append(format.format(ele) + " ");
    }
    System.out.println(builder.toString());
  }
}
