package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Access(AccessType.PROPERTY)
public class Administrator extends Actor {
	public Administrator() {
		super();

	}

	@Override
	public String toString() {
		return "Administrator [getNombre()=" + getNombre()
				+ ", getApellidos()=" + getApellidos() + ", getEmail()="
				+ getEmail() + ", getUser()=" + getUser() + ", getId()="
				+ getId() + ", getVersion()=" + getVersion() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

	// Attributes----------------------------------------------

	// toSring---------------------------------------------------

	// Relationships------------------------------------------

	private Collection<Incidencia> incidencias;

	@OneToMany(mappedBy="administrator")
	public Collection<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(Collection<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}



}
