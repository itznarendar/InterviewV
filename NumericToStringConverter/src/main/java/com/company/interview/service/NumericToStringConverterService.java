package com.company.interview.service;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.company.interview.exception.NumberException;
import com.company.interview.utils.EnumTens;
import com.company.interview.utils.EnumNum;
/*
 * core business logic implementaion for numerics toString
 */
public class NumericToStringConverterService {
	private final static Logger LOG = Logger.getLogger(NumericToStringConverterService.class.getName());

	/**
	 * @param number
	 * @return String converts input numeric which less than thousand to String
	 */
	 public  String convertNumericsUptoTripleDigit(int number) {
		LOG.log(Level.INFO, "NumericToStringConverterService::convertLessThanOneThousand started");

		try {
			String converted;
			if (number % 100 < 20) {

				converted = retrieveEnumNumber(number % 100);
				number /= 100;
			} else {
				converted = retrieveEnumNumber(number % 10);
				number /= 10;

				converted = retrieveTenEnums(number % 10) + converted;
				number /= 10;
			}
			if (number == 0)
				return converted;

			LOG.log(Level.INFO, "NumericToStringConverterService::convertLessThanOneThousand ends");

			return retrieveEnumNumber(number) + " hundred " + converted;
		} catch (NumberException ex) {
			LOG.log(Level.SEVERE,
					"NumericToStringConverterService ::convertLessThanOneThousand error while convertLessThanOneThousand",
					ex);
			throw new NumberException(ex.getMessage());

		}
	}
//retrurning enum values upto 19
	public static String retrieveEnumNumber(int num) {
		for (EnumNum enu : EnumNum.values()) {
			if (num == enu.getString()) {
				return enu.name();
			}
		}
		return "";

	}
	//retrurning enum values from tens
	public static String retrieveTenEnums(int number) {
		for (EnumTens n : EnumTens.values()) {
			if (number == n.getString()) {
				return n.name();
			}
		}
		return "";

	}

	/**
	 * @param number
	 * @return String this method to convert number to string
	 */
	  public String covertNumericToString(int number) {
		LOG.log(Level.INFO, "NumericToStringConverterService::covertNumericToString started");
		try {
			if (number == 0) {
				return "zero";
			}
			String numberString = Long.toString(number);
			String mask = "000000000000";
			DecimalFormat df = new DecimalFormat(mask);
			numberString = df.format(number);

			int billions = Integer.parseInt(numberString.substring(0, 3));
			int millions = Integer.parseInt(numberString.substring(3, 6));
			int hundredThousands = Integer.parseInt(numberString.substring(6, 9));
			int thousands = Integer.parseInt(numberString.substring(9, 12));

			String trBillions;
			switch (billions) {
			case 0:
				trBillions = "";
				break;
			case 1:
				trBillions = convertNumericsUptoTripleDigit(billions) + " billion ";
				break;
			default:
				trBillions = convertNumericsUptoTripleDigit(billions) + " billion ";
			}
			String result = trBillions;

			String tradMillions;
			switch (millions) {
			case 0:
				tradMillions = "";
				break;
			case 1:
				tradMillions = convertNumericsUptoTripleDigit(millions) + " million ";
				break;
			default:
				tradMillions = convertNumericsUptoTripleDigit(millions) + " million ";
			}
			result = result + tradMillions;

			String trHundredThousands;
			switch (hundredThousands) {
			case 0:
				trHundredThousands = "";
				break;
			case 1:
				trHundredThousands = "one thousand ";
				break;
			default:
				trHundredThousands = convertNumericsUptoTripleDigit(hundredThousands) + " thousand ";
			}
			result = result + trHundredThousands;
			String trThousand;
			trThousand = convertNumericsUptoTripleDigit(thousands);
			result = result + trThousand;

			LOG.log(Level.INFO, "NumericToStringConverterService::covertNumericToString end");
			return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");

		} catch (NumberFormatException ex) {
			LOG.log(Level.SEVERE, "Error Occured while covertNmToString", ex);
			throw new NumberException(ex.getMessage());

		}

	}

}
