package com.airwallex.xiangyu;

import com.airwallex.xiangyu.calculator.Calculator;
import com.airwallex.xiangyu.calculator.RPNCalculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RpnCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpnCalculatorApplication.class, args);

		Calculator calculator = new RPNCalculator();
		calculator.calculate();
	}

}
