package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.hibernate.validator.constraints.URL;


@Entity
@Access(AccessType.PROPERTY)
public class Establecimiento extends DomainEntity{
	
	
	public Establecimiento(){
		super();
	}
	
	private String nombre, descripcion, direccion, web, numeroTelefono, tipoEstablecimiento, campus;
	
	
	public void setCampus(String campus) {
		this.campus = campus;
	}

	private Boolean publicado;
	
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
	
	@SafeHtml(whitelistType = WhiteListType.NONE)
	@NotBlank
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@SafeHtml(whitelistType = WhiteListType.NONE)
	@URL
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	
	@NotBlank
	@Pattern(regexp="^\\d+$")	
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}	
	
	@NotBlank
	@Pattern(regexp = "^BAR|RESTAURANTE|COMEDOR UNIVERSITARIO|OTROS$")
	public String getTipoEstablecimiento() {
		return tipoEstablecimiento;
	}
	public void setTipoEstablecimiento(String tipoEstablecimiento) {
		this.tipoEstablecimiento = tipoEstablecimiento;
	}
	
	@Pattern(regexp = "^CAMPUS CARTUJA|CAMPUS MACARENA|CAMPUS REINA MERCEDES|CAMPUS RAMON Y CAJAL|ESCUELA POLITÉCNICA SUPERIOR|FACULTAD BELLAS ARTES|SADUS|OTROS$")
	public String getCampus() {
		return campus;
	}
	
	public Boolean getPublicado() {
		return publicado;
	}
	public void setPublicado(Boolean publicado) {
		this.publicado = publicado;
	}
	
	
	//Relaciones------------------
	private Collection<Oferta>ofertas;
	private Proveedor proveedor;
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
	@OneToMany(mappedBy="establecimiento")
	public Collection<Oferta> getOfertas() {
		return ofertas;
	}
	public void setOfertas(Collection<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	
	@ManyToOne(optional=false)
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
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

	
	

}
