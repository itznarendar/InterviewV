package com.company.interview;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.company.interview.validation.NummericToStringValidator;
//starts the application 
public class NumericToStringConverter {
	private final static Logger LOG = Logger.getLogger(NumericToStringConverter.class.getName());

	
public static void main(String[] args) {
	LOG.log(Level.INFO, "NumbertoStringConverter started");
	NummericToStringValidator input =new NummericToStringValidator();
	input.readInput();
	LOG.log(Level.INFO, "NumbertoStringConverter end");


	 
	
}




}
