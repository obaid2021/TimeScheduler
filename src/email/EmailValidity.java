package email;



import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import warnings.Error;
/**
 * This class checks the validity of the email by using javax.mail.jar.
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 */
public class EmailValidity {
	 /**
	  * This function uses javax.mail.jar to check the validity of email address. 
	  * @param email string value that will be checked
	  * @return returns true if email is valid else false
	  */
	public boolean isValidEmailAddress(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
			   Error error= new Error();
				error.errorWarning("Provided Email is invalid");     
		      result = false;
		   }
		   return result; 
		}
}
