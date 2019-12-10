package com.company.interview.validation;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.company.interview.service.NumericToStringConverterService;

public class NummericToStringValidator {
	private final static Logger LOG = Logger.getLogger(NummericToStringValidator.class.getName());
	NumericToStringConverterService numericToStringConverterService=new NumericToStringConverterService();
	/**
	 * @return int 
	 * reads console i/p
	 */
	public  void readInput() {
		LOG.info("NummericToStringValidator::readInput start");
		Scanner scanner=new Scanner(System.in);
		readString(scanner);
		LOG.log(Level.INFO,"NummericToStringValidator::readInput end");
	}

	private void readString(Scanner scanner) {
		LOG.info("NummericToStringValidator::readString start");		
		int number=0;
		try {
		      System.out.println("Please Enter Numeric input");

			 while ((number = scanner.nextInt()) != 0) {
			 	if(number>0) {
				  System.out.println("Your entered Numeric Input is " + number);
				  
				  String word= numericToStringConverterService.covertNumericToString(number);
				  System.out.println(" English String for the number is "+number+" is"+word);
			      System.out.println("Please Enter Numeric input");
			 	}else {
			 		System.out.println("Entered number is Invalid please enter valid");
			 		readString(scanner);
			 	}
			 }
			 LOG.info("NummericToStringValidator::readString end");
		}catch(InputMismatchException e) {
			scanner.next();
			LOG.log(Level.SEVERE, "error while reading input",e);
			readString(scanner);

			
		}
	
	}


}
