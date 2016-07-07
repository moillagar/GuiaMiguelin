package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;


@Entity
@Access(AccessType.PROPERTY)
public class Proveedor extends Clientes {

	public Proveedor() {
		super();
	}

	
	
	
	// relaciones
	private Collection<Establecimiento> establecimientos;

	@OneToMany(mappedBy = "proveedor")
	public Collection<Establecimiento> getEstablecimientos() {
		return establecimientos;
	}

	public void setEstablecimientos(Collection<Establecimiento> establecimientos) {
		this.establecimientos = establecimientos;
	}
	
	

}
