package com.airwallex.xiangyu.exception;

public class UnSupportedOperatorExecption extends Exception {
  private String message;

  public UnSupportedOperatorExecption(){
    super();
  }

  public UnSupportedOperatorExecption(String message){
    super(message);
    this.message = message;
  }
}
