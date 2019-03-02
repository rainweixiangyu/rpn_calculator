package com.airwallex.xiangyu.model;


import com.airwallex.xiangyu.exception.UnSupportedOperatorExecption;

import java.util.HashMap;
import java.util.Map;

public enum OperatorType {
  PLUS("+"),
  MINUS("-"),
  MULTIPLY("*"),
  DIVIDE("/"),
  SQRT("sqrt"),
  UNDO("undo"),
  CLEAR("clear"),
  EXIT("exit");

  private String name;

  public String getName() {
    return name;
  }

  OperatorType(String name){
    this.name = name;
  }

  private final static Map<String, OperatorType> lookup = new HashMap<>();
  static {
    for(OperatorType type : values()){
      lookup.put(type.getName(),type);
    }
  }

  public static OperatorType from(String name) throws UnSupportedOperatorExecption{
    if(null == lookup.get(name)){
      throw new UnSupportedOperatorExecption("Operator ["+name+"] is not supported.");
    }

    return lookup.get(name);
  }
}
