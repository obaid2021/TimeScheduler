package utilities;

/**
 * This class converts the string value of dates into integer values.
 * 
 * @author Muhammad Obaid Ullah, Syed Adil Ehsan, Rao Shahan Naveed
 *
 */
public class StringIntTime {
	/**
	 * This function takes date as an input and returns the 2 digits of date.
	 * @param date date in the format of Mon,00 YEAR.
	 * @return returns 2 digits of date.
	 */
	public String get_date(String date) {
		String day = null;
		if (date.substring(5, 6).equals(",")) {
			day = date.substring(4, 5);
		} else {

			day = date.substring(4, 6);
		}
		return day;
	}

	/**
	 * This function takes date as an input and returns the 4 digits of year from
	 * it.
	 * 
	 * @param date date in the format of Mon,00 YEAR.
	 * @return returns 4 digits of year.
	 */
	public String get_year(String date) {
		String year;
		if (date.substring(5, 6).equals(",")) {
			year = date.substring(8);
		} else {

			year = date.substring(9);
		}
		return year;
	}

	/**
	 * This function converts the string value of day into integer value.
	 * 
	 * @param dateString string value of date.
	 * @return integer value of date.
	 */
	public int get_day_int(String dateString) {
		int date = 0;

		if (dateString.substring(5, 6).equals(",")) {
			date = Integer.parseInt(dateString.substring(4, 5));

		} else {
			date = Integer.parseInt(dateString.substring(4, 6));
		}
		return date;
	}

	/**
	 * This function converts the string value of month into integer value.
	 * 
	 * @param monthString string value of month.
	 * @return integer value of month.
	 */
	public int get_month_int(String monthString) {
		int month = 0;
		monthString = monthString.substring(0, 3);
		Months convert = new Months();
		month = convert.get_month_number(monthString);

		return month;
	}

	/**
	 * This function converts the string value of year into integer value.
	 * 
	 * @param yearString string value of year.
	 * @return integer value of year.
	 */
	public int get_year_int(String yearString) {
		int year = 0;
		if (yearString.substring(5, 6).equals(",")) {
			year = Integer.parseInt(yearString.substring(7));

		} else {
			year = Integer.parseInt(yearString.substring(8));
		}

		return year;
	}
}
