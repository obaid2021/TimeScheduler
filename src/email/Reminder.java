package email;

 

public class Reminder extends Thread {
public void run() {
	while(true)
	{
		
	}
}
	
	/*	
	public static void schedule_email_reminder() {
		 
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
		 	@Override
			public void run() {
				 
			}		
		};
		
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR,2020);
		date.set(Calendar.MONTH,Calendar.DECEMBER);
		date.set(Calendar.DAY_OF_MONTH,31);
		date.set(Calendar.HOUR_OF_DAY,23);
		date.set(Calendar.MINUTE,59);
		date.set(Calendar.SECOND,50);
		date.set(Calendar.MILLISECOND,0);
		
		//timer.schedule(task, 0);
		//timer.schedule(task, date.getTime());
		//timer.scheduleAtFixedRate(task, 0, 1000);
		timer.scheduleAtFixedRate(task, date.getTime(), 1000);
	}
*/
}