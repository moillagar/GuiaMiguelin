package services;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.ClientesRepository;
import security.LoginService;
import security.UserAccount;
import domain.Clientes;
import forms.PasswordForm;

@Service
@Transactional
public class ClientesService {
	
	// Managed repository -----------------------------------------------------
	
		@Autowired
		private ClientesRepository customerRepository;
		
		// Supporting services-----------------------------------------------------
		
		// Constructors -----------------------------------------------------------
		
		public ClientesService() {
			super();
		}

		// Simple CRUD methods-------------------------------------------------------------

		public Clientes create() {
			Clientes result;
			result = new Clientes();
			return result;
		}
		
		public void save(Clientes customer) {
			Assert.notNull(customer,"intentando guardar un cliente nulo");
			customerRepository.save(customer);
		}

		public Clientes findOne(Integer id) {
			Assert.isTrue(id!=0,"tried to find a customer with id zero");
			return customerRepository.findOne(id);
		}

		public Collection<Clientes> findAll() {
			return customerRepository.findAll();
		}

		public void delete(Clientes i) {
			Assert.notNull(i,"intentando borrar un cliente nulo");
			customerRepository.delete(i);
		}

		// Other business methods -------------------------------------------------
		
		public Clientes getLoggedCustomer() {
			Clientes result;
			UserAccount user;
			user = LoginService.getPrincipal();
			result = customerRepository.findActorByUsername(user.getUsername());
			return result;
		}

		public Clientes findCustomerByuserName(String userName) {
			Clientes result;
			result = customerRepository.findCustomerByUserNmae(userName);
			return result;
		}

		public void changePassword(PasswordForm pForm) {
			Md5PasswordEncoder encoder = new Md5PasswordEncoder();
			Clientes clientes;
			clientes = findCustomerByuserName(pForm.getUsername());
			
			clientes.getUser().setPassword(encoder.encodePassword(pForm.getPassword(), null));
			save(clientes);

			
		}
}

