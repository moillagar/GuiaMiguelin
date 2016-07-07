package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;


@Entity
@Access(AccessType.PROPERTY)
public class Clientes extends Actor{
	
	public Clientes() {
		super();
		
	}

	//Atributos--------------------------
	
	private Boolean cuentaDesactivada;
	private String userCode;
	
	//@Pattern(regexp = "^\\w+(-\\w+)?$")
	// @Column(unique = true)
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}	


	public Boolean getCuentaDesactivada() {
		return cuentaDesactivada;
	}

	public void setCuentaDesactivada(Boolean cuentaDesactivada) {
		this.cuentaDesactivada = cuentaDesactivada;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Clientes [getNombre()=" + getNombre() + ", getApellidos()="
				+ getApellidos() + ", getEmail()=" + getEmail()
				+ ", getUser()=" + getUser() + ", getId()=" + getId()
				+ ", getVersion()=" + getVersion() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}


	


}
