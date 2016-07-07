package services;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Estudiante;
import domain.Proveedor;
@Service
@Transactional
public class SendEmail {
	//No tocar en fase de construccion
	//funciona con un correo normal desabilitando la opcion de seguridad en gmail
	public void send(String emailRecipient, String content, String subject) {

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
							return new PasswordAuthentication(
									"guiamiguelininfo@gmail.com", "guiamiguelin");
						}

					});
			MimeMessage email = new MimeMessage(session);
			email.setFrom(new InternetAddress("guiamiguelininfo@gmail.com"));
			email.addRecipient(Message.RecipientType.TO, new InternetAddress(
					emailRecipient));
			email.setSubject(subject);
			// email.setText("<a href='#'>asad</a>Holaaaa");
			email.setContent(content, "text/html");
			Transport t = session.getTransport("smtp");

			Transport.send(email);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sendToAFriend(Estudiante sender, String recipient) {
		String url;
		// url = "http://www.acme.com/single/register.do?invitationCode="
		// + sender.getUserCode();
		url = "http://localhost:8080/GuiaMiguelin";

		String content;
		String subject;
		subject = "Invitation to Guia Miguelin";

		content = "Hello, "
				+ sender.getNombre()
				+ " "
				+ sender.getApellidos()
				+ " has invited you to join Guia Miguelin. Please,click the link below to join if you want.";
		content += "</br><a href="+url+">Click here</a><br>";

		send(recipient, content, subject);
	}
	
	
	
}
