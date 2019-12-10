package com.company.interview.utils;
/*
 * enum for numerics one to nineteen
 */
public enum EnumNum {
	one(1), two(2), three(3), four(4), five(5), six(6), seven(7), eight(8), nine(9), ten(10), eleven(11), twelve(12),
	thirteen(13), fourteen(14), fifteen(15), sixteen(16), seventeen(17), eighteen(18), nineteen(19);

	private int numString;
	EnumNum(int numString) {
		this.numString = numString;
	}

	public int getString() {
		return numString;
	}

}