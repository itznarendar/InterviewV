package com.company.interview.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.company.interview.service.NumericToStringConverterService;

public class NumerictoStringConverterTest {
	NumericToStringConverterService numericToStringConverterService=new NumericToStringConverterService();;
	
	
		 @Test  
		    public void testNumberToStringNormal(){  
			 	String value= numericToStringConverterService.covertNumericToString(99999);
			 	assertNotNull(value);
			 	
		    }  
		 @Test(expected = NumberFormatException.class)
		    public void testNumberToStringSpecial(){  
			 numericToStringConverterService.covertNumericToString(Integer.parseInt("#@&@"));
		  
		 }  
		 @Test(expected = NumberFormatException.class)
		    public void testNumberToStringCharInput(){  
			 numericToStringConverterService.convertNumericsUptoTripleDigit(Integer.parseInt("dd"));
		    }  
		@Test  
		    public void testNumberToStringTripleDig(){  
			 	String value= numericToStringConverterService.convertNumericsUptoTripleDigit(999);
			 	assertNotNull(value);
			 	
		    }  
		
		 
		 @Test  
		    public void testNumberToStringBigNum(){  
			 	String value= numericToStringConverterService.covertNumericToString(999999999);
			 	assertNotNull(value);
		    }  
		 
		
		
		 
		 
	 
}
