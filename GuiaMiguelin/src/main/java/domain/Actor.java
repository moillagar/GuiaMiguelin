package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

import security.LoginService;
import security.UserAccount;


@Entity
@Access(AccessType.PROPERTY)
public class Actor extends DomainEntity{
	 //Constructor-------------------------------------------------
		public Actor(){
			super();
			
		}
		
		//Attributes----------------------------------------------
		private String nombre, apellidos;
		private String email;
		
		

		@SafeHtml(whitelistType = WhiteListType.NONE)
		@NotBlank
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		@SafeHtml(whitelistType = WhiteListType.NONE)
		@NotBlank
		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		@SafeHtml(whitelistType = WhiteListType.NONE)
		@NotBlank
		@Email
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
				
		//Relationships------------------------------------------
		private UserAccount user;
		
		@Valid
		@OneToOne(optional=false,cascade=CascadeType.ALL)
		public UserAccount getUser() {
			return user;
		}

		public void setUser(UserAccount user) {
			this.user = user;
		}

		

		

		
}
