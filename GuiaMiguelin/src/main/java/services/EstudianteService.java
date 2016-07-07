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

import repositories.EstudianteRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Estudiante;
import domain.Photo;
import forms.EstudianteForm;


@Service
@Transactional
public class EstudianteService {

	
	public EstudianteService(){
		super();
	}
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	

	// Simple CRUD
	// methods-------------------------------------------------------------

	public Estudiante create() {
		Estudiante result;
		result = new Estudiante();
		result.setCuentaDesactivada(false);
		
		return result;
	}

	public void save(Estudiante estudiante) {
		Assert.notNull(estudiante, "intentando guardar un cliente nulo");
		estudianteRepository.save(estudiante);
	}

	public Estudiante findOne(Integer id) {
		Assert.isTrue(id != 0, "tried to find a customer with id zero");
		return estudianteRepository.findOne(id);
	}

	public Collection<Estudiante> findAll() {
		return estudianteRepository.findAll();
	}

	public void delete(Estudiante i) {
		Assert.notNull(i, "intentando borrar un cliente nulo");
		estudianteRepository.delete(i);
	}
	
	
	
	public Estudiante getLoggedSingle() {
		Estudiante result;
		UserAccount user;
		user = LoginService.getPrincipal();
		result = estudianteRepository.findEstudianteByUsername(user.getUsername());
		return result;
	}
	
	public Estudiante findSinglesByUserCode(String userCode) {
		Estudiante result;
		result = estudianteRepository.findEstudianteByUserCode(userCode);
		return result;
	}
	
	
	public Estudiante register(Estudiante estudiante) {
		Assert.notNull(estudiante);
		Estudiante result;
		UserAccount user;
	
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		user = estudiante.getUser();
		user.setPassword(encoder.encodePassword(user.getPassword(), null));
		estudiante.setUser(user);
		
		if (estudiante.getInviteCode() != null) {
			// check that the single who sent the email exists
			Estudiante senderEstudiante;
			senderEstudiante = findSinglesByUserCode(estudiante.getInviteCode());
			Assert.notNull(senderEstudiante);
			
			estudianteRepository.save(senderEstudiante);
		}
		String inviteCode2=RandomStringUtils.randomAlphabetic(10);
		estudiante.setInviteCode(inviteCode2);
		result = estudianteRepository.save(estudiante);

		return result;

	}

	public Estudiante reconstruct(EstudianteForm estudianteForm) {
		Estudiante result;
		result = create();
		// check if the passwords are the same
		String password;
		password = estudianteForm.getPassword();
		Assert.isTrue(estudianteForm.getRepeatedPassword().equals(password));

	

		// now we create the user account, once the object form is validated
		UserAccount user;
		user = new UserAccount();
		String userName;
		userName = estudianteForm.getUserName();
		user.setUsername(estudianteForm.getUserName());
		user.setPassword(password);

		Authority aut;
		aut = new Authority();
		aut.setAuthority(Authority.ESTUDIANTE);
		user.addAuthority(aut);
		result.setUser(user);

		result.setNombre(estudianteForm.getNombre());
		result.setApellidos(estudianteForm.getApellidos());
		result.setEmail(estudianteForm.getEmail());
		result.setFechaNacimiento(estudianteForm.getFechaNacimiento());
		result.setTitulacion(estudianteForm.getTitulacion());
		
		
		
		// generating user code, bluilt by means of username
		result.setUserCode("code" + userName);
		if (estudianteForm.getInviteCode() != null) {
			result.setInviteCode(estudianteForm.getInviteCode());
		}
		return result;

	}

	public EstudianteForm createEstudianteForm() {
		EstudianteForm result;
		result = new EstudianteForm();
		return result;

	}
	
	public void sendToActivate(Estudiante sender) {
		String url;
//		url = "http://www.acme.com/single/activateAccount.do?userCode="
//		+ sender.getUserCode();
		url = "http://localhost:8080/GuiaMiguelin/estudiante/activateAccount.do?userCode="
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

	public void sendToAFriend(Estudiante sender, String recipient) {
		String url;
//		url = "http://www.acme.com/single/register.do?invitationCode="
//				+ sender.getUserCode();
		url = "http://localhost:8080/GuiaMiguelin/estudiante/register.do?invitationCode="
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
	
/*
	public void changeAvatar(Estudiante estudiante, Photo photo) {
		for(Photo p : estudiante.getPhotos()){
			if(p.getAvatar()==true){
				p.setAvatar(false);
			}
		}
		
		
		for(Photo p1 : estudiante.getPhotos()){
			if(p1 == photo){
				p1.setAvatar(true);
			}
		}
	}*/
	
	
	
	
	public boolean exists(Estudiante estudiante) {
		boolean result;
		result = estudianteRepository.exists(estudiante.getId());
		return result;
	}

	public void flush() {
		estudianteRepository.flush();

	}
	
	
}
