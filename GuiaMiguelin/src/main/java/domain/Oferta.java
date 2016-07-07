package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;


@Entity
@Access(AccessType.PROPERTY)
public class Oferta extends DomainEntity{
	
	public Oferta(){
		super();
	}
	
	private String nombre, descripcion;
	private Double precio;
	private String codigo;
	private Double calificacionMedia;
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Range(min = 0)
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	@Pattern(regexp = "^\\w+(-\\w+)?$")
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@Transient
	public Double getCalificacionMedia() {
		Integer sum = 0;
		Integer sum2=0;
		Integer sum3 =0;
		if(calificacionOfertas.size()==0){
			sum3=0;
		}else{
			if(calificacionOfertas.size()!=0){
		for (CalificacionOferta c: calificacionOfertas){
			sum+= c.getCalificacion();
		
		sum2 = calificacionOfertas.size();
		sum3=sum/sum2;
				}
			}
		}
			
			
			
		return (double) (sum3);
	
		
	}
		
		
	public void setCalificacionMedia(Double calificacionMedia) {
		this.calificacionMedia = calificacionMedia;
	}
	
	
	//Relaciones-----------
	private Collection<CalificacionOferta>calificacionOfertas;
	private Collection<Incidencia>incidencias;
	
	
	@OneToMany(mappedBy="oferta")
	public Collection<Incidencia> getIncidencias() {
		return incidencias;
	}
	public void setIncidencias(Collection<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

	private Establecimiento establecimiento;

	@OneToMany(mappedBy="oferta")
	public Collection<CalificacionOferta> getCalificacionOfertas() {
		return calificacionOfertas;
	}
	public void setCalificacionOfertas(
			Collection<CalificacionOferta> calificacionOfertas) {
		this.calificacionOfertas = calificacionOfertas;
	}
	
	@ManyToOne(optional=false)
	public Establecimiento getEstablecimiento() {
		return establecimiento;
	}
	public void setEstablecimiento(Establecimiento establecimiento) {
		this.establecimiento = establecimiento;
	}

}
