package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Access(AccessType.PROPERTY)
public class Estudiante extends Clientes{
	
	
	public Estudiante(){
		super();
	}
	
	private String titulacion;
	private Date fechaNacimiento;

	@NotNull
	@Past
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	@SafeHtml(whitelistType = WhiteListType.NONE)
	@NotBlank
	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	
	
	//Relaciones----------------------
	/*private Photo photo;
	@OneToOne(optional=true)
	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}*/
	private byte[] photo;
	
	@Lob
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	private Collection<CalificacionOferta>calificacionOfertas;
	private Collection<Incidencia>incidencias;
	
	
	

		/*
		@javax.persistence.Transient
		public Photo getAvatar() {
			Photo result = null;
			for (Photo p : photos) {
				if (p.getAvatar()) {
					result = p;
					break;
				}
			}

			return result;
		}*/

		@OneToMany(mappedBy="estudiante")
		public Collection<CalificacionOferta> getCalificacionOfertas() {
			return calificacionOfertas;
		}

		public void setCalificacionOfertas(
				Collection<CalificacionOferta> calificacionOfertas) {
			this.calificacionOfertas = calificacionOfertas;
		}
		@OneToMany(mappedBy="estudiante")
		public Collection<Incidencia> getIncidencias() {
			return incidencias;
		}

		public void setIncidencias(Collection<Incidencia> incidencias) {
			this.incidencias = incidencias;
		}

		private String inviteCode;

		@Pattern(regexp = "^\\w+(-\\w+)?$")
		public String getInviteCode() {
			return inviteCode;
		}

		public void setInviteCode(String inviteCode) {
			this.inviteCode = inviteCode;
		}
		
	


}
