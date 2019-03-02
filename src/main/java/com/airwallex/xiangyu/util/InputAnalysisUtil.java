package com.airwallex.xiangyu.util;

import java.util.regex.Pattern;

public class InputAnalysisUtil {
  public static boolean isNumber(String input){
    Pattern pattern = Pattern.compile("^[+\\-]?[\\d]+(.[\\d]+)?$");
    if(pattern.matcher(input).matches()){
      return true;
    }else{
      return false;
    }
  }
}
