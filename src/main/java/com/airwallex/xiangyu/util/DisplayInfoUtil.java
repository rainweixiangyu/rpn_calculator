package com.airwallex.xiangyu.util;

public class DisplayInfoUtil {
  public static void displayNonSufficientInfo(String[] inputArray, int pos){
    if(pos < inputArray.length){
      StringBuilder str = new StringBuilder("(the ");
      str.append(inputArray[pos]+" ");
      for(int i=pos+1;i<inputArray.length;i++){
        if(i == inputArray.length-1){
          str.append("and "+inputArray[i]);
        }else {
          str.append("," + inputArray[i]+" ");
        }
      }
      str.append(" were not pushed on to the stack due to the previous error)");
      System.out.println(str.toString());
    }
  }

  public static void displayWelcomeInfo(){
    System.out.println("====Welcome to RPN Calculator====");
    System.out.println("Supported operators:");
    System.out.println("+:    Addition");
    System.out.println("-:    Subtraction");
    System.out.println("*:    Multiplication");
    System.out.println("/:    Division");
    System.out.println("sqrt: Square root");
    System.out.println("undo: Undoes the previous operation");
    System.out.println("clear:Removes all items from the stack");
    System.out.println("exit: Exit calculator");
    System.out.println("Please start your calculation.");
    System.out.println("==================================");
  }

  public static void displayInputHint(){
    System.out.print(">");
  }
}
