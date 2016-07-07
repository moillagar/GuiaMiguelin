package services;

import java.util.Collection;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.ProveedorRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Estudiante;
import domain.Proveedor;
import forms.EstudianteForm;
import forms.ProveedorForm;


@Service
@Transactional
public class ProveedorService {
	
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	public Proveedor getLoggedProveedor() {
		Proveedor result;
		UserAccount user;
		user = LoginService.getPrincipal();
		result = proveedorRepository.findProveedorByUsername(user.getUsername());
		return result;
	}
	
	public Proveedor findProveedorByUserCode(String userCode) {
		Proveedor result;
		result = proveedorRepository.findProveedorByUserCode(userCode);
		return result;
	}
	
	public ProveedorForm createProveedorForm() {
		ProveedorForm result;
		result = new ProveedorForm();
		return result;

	}

	public Proveedor reconstruct(ProveedorForm proveedorForm) {
		Proveedor result;
		result = create();
		// check if the passwords are the same
		String password;
		password = proveedorForm.getPassword();
		Assert.isTrue(proveedorForm.getRepeatedPassword().equals(password));



		// now we create the user account, once the object form is validated
		UserAccount user;
		user = new UserAccount();
		String userName;
		userName = proveedorForm.getUserName();
		user.setUsername(proveedorForm.getUserName());
		user.setPassword(password);

		Authority aut;
		aut = new Authority();
		aut.setAuthority(Authority.PROVEEDOR);
		user.addAuthority(aut);
		result.setUser(user);

		result.setNombre(proveedorForm.getNombre());
		result.setApellidos(proveedorForm.getApellidos());
		result.setEmail(proveedorForm.getEmail());
	
		return result;

	}
	
	
	public Proveedor register(Proveedor proveedor) {
		Assert.notNull(proveedor);
		Proveedor result;
		UserAccount user;
	
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		user = proveedor.getUser();
		user.setPassword(encoder.encodePassword(user.getPassword(), null));
		proveedor.setUser(user);
	
	
		
		result = proveedorRepository.save(proveedor);

		return result;

	}
	
	public void sendToActivate(Proveedor sender) {
		String url;
//		url = "http://www.acme.com/single/activateAccount.do?userCode="
//		+ sender.getUserCode();
		url = "http://localhost:8080/GuiaMiguelin/proveedor/activateAccount.do?userCode="
				+ sender.getUserCode();
		String recipient;
		recipient = sender.getEmail();
		String content;
		String subject;
		subject = "Activate your account of Guia Miguelin";

		content = "Hello, "
				+ sender.getNombre()
				+ " "
				+ sender.getApellidos()
				+ " You have registered in Guia Miguelin. Please,click the link below to activate your account if you want. Thanks you.";
		content += "</br><a href='" + url + "'><br>Click here</a><br>"
				+ "<img src='http://qrickit.com/api/qr?d=" + url
				+ "' style='width:256px;height:256px'>";

		send(recipient, content, subject);
	}
	
	
	public void sendToAFriend(Proveedor sender, String recipient) {
		String url;
//		url = "http://www.acme.com/single/register.do?invitationCode="
//				+ sender.getUserCode();
		url = "http://localhost:8080/GuiaMiguelin/proveedor/register.do?invitationCode="
				+ sender.getUserCode();

		String content;
		String subject;
		subject = "Invitation to Guia Miguelin";

		content = "Hello, "
				+ sender.getNombre()
				+ " "
				+ sender.getApellidos()
				+ " has invited you to join Guia Miguelin. Please,click the link below to join if you want.";
		content += "</br><a href='" + url + "'>Click here</a><br>"
				+ "<img src='http://qrickit.com/api/qr?d=" + url
				+ "' style='width:256px;height:256px'>";

		send(recipient, content, subject);
	}
	
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
									"guiamiguelinInfo@gmail.com", "guiamiguelin");
						}

					});
			MimeMessage email = new MimeMessage(session);
			email.setFrom(new InternetAddress("guiamiguelinInfo@gmail.com"));
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
	
	
	
	private Proveedor create() {
		Proveedor result;
		result = new Proveedor();
		result.setCuentaDesactivada(false);
		return result;
	}

	public void save(Proveedor proveedor) {
		proveedorRepository.save(proveedor);
		
	}

	public Collection<Proveedor> findAll() {
		
		return proveedorRepository.findAll();
	}
	
	
}
