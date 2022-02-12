

package utilities;

import userInterface.ViewMonth;
/**
 * this class will determine the names of the days.
 * @author Muhammad Obaid Ullah, Syed Adil Ehsan, Rao Shahan Naveed
 *
 */
public class DaysOfWeek {
/**
 *this function will determine the names of the next 6 days starting from the day that is given. 
 * @param day name of the first day.
 */
	public void daysOfWeek(String day) {
	 
		 
		if (day.equals(ViewMonth.standardDays[0])) {
			ViewMonth.days[0] = "SUNDAY";
			ViewMonth.days[1] = "MONDAY";
			ViewMonth.days[2] = "TUESDAY";
			ViewMonth.days[3] = "WEDNESDAY";
			ViewMonth.days[4] = "THURSDAY";
			ViewMonth.days[5] = "FRIDAY";
			ViewMonth.days[6] = "SATURDAY";
		}
		if (day.equals(ViewMonth.standardDays[1])) {
			ViewMonth.days[0] = "MONDAY";
			ViewMonth.days[1] = "TUESDAY";
			ViewMonth.days[2] = "WEDNESDAY";
			ViewMonth.days[3] = "THURSDAY";
			ViewMonth.days[4] = "FRIDAY";
			ViewMonth.days[5] = "SATURDAY";
			ViewMonth.days[6] = "SUNDAY";
		}
		if (day.equals(ViewMonth.standardDays[2])) {
			ViewMonth.days[0] = "TUESDAY";
			ViewMonth.days[1] = "WEDNESDAY";
			ViewMonth.days[2] = "THURSDAY";
			ViewMonth.days[3] = "FRIDAY";
			ViewMonth.days[4] = "SATURDAY";
			ViewMonth.days[5] = "SUNDAY";
			ViewMonth.days[6] = "MONDAY";
		}
	 
		if (day.equals(ViewMonth.standardDays[3])) {
			ViewMonth.days[0] = "WEDNESDAY";
			ViewMonth.days[1] = "THURSDAY";
			ViewMonth.days[2] = "FRIDAY";
			
			ViewMonth.days[3] = "SATURDAY";
			ViewMonth.days[4] = "SUNDAY";
			ViewMonth.days[5] = "MONDAY";
			ViewMonth.days[6] = "TUESDAY";
		}
		if (day.equals(ViewMonth.standardDays[4])) {
			ViewMonth.days[0] = "THURSDAY";
			ViewMonth.days[1] = "FRIDAY";
			ViewMonth.days[2] = "SATURDAY";
			ViewMonth.days[3] = "SUNDAY";
			ViewMonth.days[4] = "MONDAY";
			ViewMonth.days[5] = "TUESDAY";
			ViewMonth.days[6] = "WEDNESDAY";
		}
		if (day.equals(ViewMonth.standardDays[5])) {

			ViewMonth.days[0] = "FRIDAY";
			ViewMonth.days[1] = "SATURDAY";
			ViewMonth.days[2] = "SUNDAY";
			ViewMonth.days[3] = "MONDAY";
			ViewMonth.days[4] = "TUESDAY";
			ViewMonth.days[5] = "WEDNESDAY";
			ViewMonth.days[6] = "THURSDAY";
		}
		if (day.equals(ViewMonth.standardDays[6])) {

			ViewMonth.days[0] = "SATURDAY";
			 
			ViewMonth.days[1] = "SUNDAY";
			ViewMonth.days[2] = "MONDAY";
			ViewMonth.days[3] = "TUESDAY";
			ViewMonth.days[4] = "WEDNESDAY";
			ViewMonth.days[5] = "THURSDAY";
			ViewMonth.days[6] = "FRIDAY";
		}
		 
	}
}
