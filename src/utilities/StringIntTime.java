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
	 * 
	 * @param date date in the format of Mon,00 YEAR.
	 * @return returns 2 digits of date.
	 */
	public String get_date(String date) {
		String day = "";
		try {
			if (date.substring(5, 6).equals(",")) {
				day = date.substring(4, 5);
			} else {

				day = date.substring(4, 6);
			}
		} catch (Exception e) {
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
		String year = "";
		try {

			if (date.substring(5, 6).equals(",")) {
				year = date.substring(7);
			} else {

				year = date.substring(8);
			}
		} catch (Exception e) {
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
         try {
		if (dateString.substring(5, 6).equals(",")) {
			date = Integer.parseInt(dateString.substring(4, 5));

		} else {
			date = Integer.parseInt(dateString.substring(4, 6));
		}}
         catch(Exception e)
 		{
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
		try {
		if (yearString.substring(5, 6).equals(",")) {
			year = Integer.parseInt(yearString.substring(7));

		} else {
			year = Integer.parseInt(yearString.substring(8));
		}
		}
		 catch(Exception e)
 		{
 	 	}
		return year;
	}

	/**
	 * 
	 * @param date
	 * @param time
	 * @return
	 */
	public String date_format_change(String date, String time) {
		Months change = new Months();
		int mon;
		String mixed = "", mixedTime = "", month = "", day = "", year = "";
		String mixedDate = "";
		mon = change.get_month_number(date.substring(0, 3));

		if (mon < 10) {
			month = "0";
			month = month + Integer.toString(mon);
		} else {
			month = Integer.toString(mon);
		}
		day = get_date(date);
		year = get_year(date);
		mixedDate = year + month + day;
		try {
		mixedTime = time.substring(0, 2) + time.substring(3, 5) + time.substring(6, 8);
		} catch(Exception e)
 		{
 	 	}
		mixed = mixedDate + mixedTime;

		return mixed;
	}

	public int time_difference(String currTime, String reminder) {
		int dif = 0;
		String var = currTime.substring(2);
		int currTimeMin = Integer.parseInt(var);
		var = reminder.substring(2);
		int reminderMin = Integer.parseInt(var);
		var = reminder.substring(0, 2);
		int reminderHr = Integer.parseInt(var);
		var = currTime.substring(0, 2);
		int currTimeHr = Integer.parseInt(var);
	 	dif = (reminderHr - currTimeHr) * 60;
		dif = dif + (reminderMin - currTimeMin);
	 	return dif;

	}

}
