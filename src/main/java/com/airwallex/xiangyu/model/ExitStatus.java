package com.airwallex.xiangyu.model;

public enum ExitStatus {
  NORMAL(0),
  OPERATOR_ERROR(1),
  OPERAND_ERROR(2),
  PARAM_ERROR(3),
  IO_ERROR(4);

  private int value;

  public int getValue(){
    return value;
  }

  ExitStatus(int value){
    this.value = value;
  }
}
