package forms;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

public class ProveedorForm {

	private int id;
	private String userName;
	private String password;
	private String repeatedPassword;
	
	
	//Actor
	private String nombre, apellidos;
	private String email;
	
	
	//Clientes
	private Boolean cuentaDesactivada;
	private String userCode;
	
	

	
		
		
		
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Size(min = 5, max = 32)
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Size(min = 5, max = 32)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotBlank
	public String getRepeatedPassword() {
		return repeatedPassword;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}

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
	
}
