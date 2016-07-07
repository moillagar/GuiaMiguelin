package services;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.AdministratorRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Administrator;
import forms.AdministratorForm;

@Service
@Transactional
public class AdministratorService {

	@Autowired
	private AdministratorRepository administratorRepository;

	public AdministratorService() {
		super();
	}

	public Administrator create() {
		Administrator result;
		result = new Administrator();
		return result;
	}

	public Administrator save(Administrator administrator) {
		Administrator result;
		result = administratorRepository.saveAndFlush(administrator);
		return result;
	}

	public void delete(Administrator administrator) {
		administratorRepository.delete(administrator);
	}

	public Collection<Administrator> findAll() {
		Collection<Administrator> result;
		result = administratorRepository.findAll();
		return result;
	}

	public Administrator findOne(Integer id) {
		Administrator result;
		result = administratorRepository.findOne(id);
		return result;
	}

	// --------------------------
	public Administrator findAdminByUsername(String username) {
		Administrator administrator;
		UserAccount user;
		user = LoginService.getPrincipal();
		Assert.notNull(user, "El usuario no puede ser nulo");
		administrator = administratorRepository.findAdminByUsername(user.getUsername());
		return administrator;
	}

	public Administrator getLoggedAdmin() {
		Administrator result;
		UserAccount user;
		user = LoginService.getPrincipal();
		Assert.notNull(user, "El usuario no puede ser nulo");
		result = administratorRepository.findAdminByUsername(user.getUsername());
		return result;
	}

	public void flush() {
		administratorRepository.flush();
	}
	
	public Administrator register(Administrator administrator) {
		Assert.notNull(administrator);
		Administrator result;
		UserAccount user;
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		user = administrator.getUser();
		user.setPassword(encoder.encodePassword(user.getPassword(), null));
		administrator.setUser(user);
		result = administratorRepository.save(administrator);

		return result;

	}

	public Administrator reconstruct(AdministratorForm administratorForm) {
		Administrator result;
		result = create();
		// check if the passwords are the same
		String password;
		password = administratorForm.getPassword();
		Assert.isTrue(administratorForm.getRepeatedPassword().equals(password));

		
		// now we create the user account, once the object form is validated
		UserAccount user;
		user = new UserAccount();
		user.setUsername(administratorForm.getUserName());
		user.setPassword(password);

		Authority aut;
		aut = new Authority();
		aut.setAuthority(Authority.ADMIN);
		user.addAuthority(aut);
		result.setUser(user);

		// actor attributes

		result.setNombre(administratorForm.getNombre());
		result.setApellidos(administratorForm.getApellidos());	
		result.setEmail(administratorForm.getEmail());
		

		return result;

	}

	public AdministratorForm createAdministratorForm() {
		AdministratorForm result;
		result = new AdministratorForm();
		return result;

	}

}
