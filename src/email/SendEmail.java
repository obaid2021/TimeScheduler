package email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * This class will be used in sending email to the users by using javax.mail.jar library.
 * <p>
 * The default email address used by this application for sending email
 *  is <p>myapplication132@gmail.com.
 * 
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */

public class SendEmail {
	/**
	 * This functions connects with gmail account of the app sends message to the recipient.
	 * @param recipient email address of the recipient.
	 * @param subject subject of the email.
	 * @param msg main body of the email that will be sent.
	 * @return true if message was sent successfully , false if not.
	 * @throws MessagingException errors during connection with mail server.
	 */
	public boolean send_email(String recipient , String subject , String msg) throws MessagingException {
		boolean result = false;
		EmailValidity check = new EmailValidity();
		boolean valid =check.isValidEmailAddress(recipient);
		if(valid == true)
		{
			result = true;
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
	//		properties.put("mail.debug", "true");
			String myaccount = "myapplication132@gmail.com";
			String password = "Uasfra132";

			Session session = Session.getInstance(properties, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myaccount, password);
				}
			});

			Message message = prepareMessage(session, myaccount, recipient , subject , msg);
			Transport.send(message);
		}
		 return result;
	}
/**
 * 
 * @param session session that was created in send_email() function.
 * @param myaccount email account myapplication132@gmail.com of the application.
 * @param recepient email address of the email receiver.
 * @param Subject is the subject of the email.
 * @param msg Main message in the email.
 * @return returns the message to be sent if successful else null.
 */
	private static Message prepareMessage(Session session, String myaccount, String recepient , String Subject , String msg) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myaccount));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
		
		 
			message.setSubject(Subject);
			message.setText(msg);
             

			return message;
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return null;
	}
}
