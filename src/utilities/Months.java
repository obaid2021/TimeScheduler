package utilities;

/**
 * This class converts name of month to number of month and vice versa.
 * 
 * @author Muhammad Obaid Ullah, Syed Adil Ehsan, Rao Shahan Naveed
 *
 */
public class Months {
	/**
	 * This function will convert the number of month into name of month.
	 * 
	 * @param numberOfMonth integer value of the month.
	 * @return returns the first three characters of the name of the month.
	 */
	public String get_month_name(int numberOfMonth) {
		if (numberOfMonth == 1) {
			return "Jan";
		}
		if (numberOfMonth == 2) {
			return "Feb";
		}
		if (numberOfMonth == 3) {
			return "Mar";
		}
		if (numberOfMonth == 4) {
			return "Apr";
		}
		if (numberOfMonth == 5) {
			return "May";
		}
		if (numberOfMonth == 6) {
			return "Jun";
		}
		if (numberOfMonth == 7) {
			return "Jul";
		}
		if (numberOfMonth == 8) {
			return "Aug";
		}
		if (numberOfMonth == 9) {
			return "Sep";
		}
		if (numberOfMonth == 10) {
			return "Oct";
		}
		if (numberOfMonth == 11) {
			return "Nov";
		}
		if (numberOfMonth == 12) {
			return "Dec";
		}

		return "not found";
	}

	/**
	 * This function will convert the name of month into number of month.
	 * 
	 * @param month string value of the month.
	 * @return returns the integer value of the month.
	 */
	public int get_month_number(String month) {
		if (month.equals("Jan")) {
			return 1;
		}
		if (month.equals("Feb")) {
			return 2;
		}
		if (month.equals("Mar")) {
			return 3;
		}
		if (month.equals("Apr")) {
			return 4;
		}
		if (month.equals("May")) {
			return 5;
		}
		if (month.equals("Jun")) {
			return 6;
		}
		if (month.equals("Jul")) {
			return 7;
		}
		if (month.equals("Aug")) {
			return 8;
		}
		if (month.equals("Sep")) {
			return 9;
		}
		if (month.equals("Oct")) {
			return 10;
		}
		if (month.equals("Nov")) {
			return 11;
		}
		if (month.equals("Dec")) {
			return 12;
		}

		return 0;
	}
}
