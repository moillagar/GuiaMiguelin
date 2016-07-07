package domain;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public static void send(String emailDir,String userCode) {
	
		
		try {

			Properties p;
			p = new Properties();
			p.put("mail.smtp.host", "smtp.gmail.com");
			p.setProperty("mail.smtp.starttls.enable", "true");
			p.setProperty("mail.smtp.port", "587");
			
			p.setProperty("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(p,
					new Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication("acmevalentine@gmail.com",
									"ValentineDP");
						}

					});
			MimeMessage email = new MimeMessage(session);
			email.setFrom(new InternetAddress("acmevalentine@gmail.com"));
			email.addRecipient(Message.RecipientType.TO, new InternetAddress(
					emailDir));
			email.setSubject("Acme-valentine Account Activation");
			//email.setText("<a href='#'>asad</a>Holaaaa");
			email.setContent("<a href='http://localhost:8080/Acme-Valentine/single/activateAccount.do?userCode="+userCode+"'>Click here</a>", "text/html");
			Transport t = session.getTransport("smtp");
			
			Transport.send(email);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		//send("sdsa","sadasda");
	}
}
