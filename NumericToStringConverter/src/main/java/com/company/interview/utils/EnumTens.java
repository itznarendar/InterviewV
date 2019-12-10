package com.company.interview.utils;
/*
 * enum for numerics tens
 */
public enum EnumTens
{ 
	 	
	    ten(1),twenty(2),thirty(3),forty(4),fifty(5),sixty(6),seventy(7),eighty(8),ninety(9);
	    
	private int tenString;

        private EnumTens (int tenString) {
                this.tenString = tenString;
        }

		public int getString() {
			 return tenString;
		}
} 
