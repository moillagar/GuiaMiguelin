package domain;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Embeddable
@Access(AccessType.PROPERTY)
@Entity
public class Photo extends DomainEntity {

    private String filename;
    private byte[] content;
    private Long lenght;
    private String contentType;
    private Date creationMoment;
    
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Lob
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	
	@NotBlank
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	@NotNull
	public Date getCreationMoment() {
		return creationMoment;
	}
	public void setCreationMoment(Date creationMoment) {
		this.creationMoment = creationMoment;
	}
	
	public Long getLenght() {
		return lenght;
	}
	@Size(min=1,max=10000000)
	@NotNull
	public void setLenght(Long lenght) {
		this.lenght = lenght;
	}
    
	
    

}