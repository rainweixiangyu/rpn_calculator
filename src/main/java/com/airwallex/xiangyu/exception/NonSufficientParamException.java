package com.airwallex.xiangyu.exception;

import lombok.Data;

@Data
public class NonSufficientParamException extends Exception {
  private String message;

  public NonSufficientParamException(){
    super();
  }

  public NonSufficientParamException(String message){
    super(message);
    this.message = message;
  }
}
