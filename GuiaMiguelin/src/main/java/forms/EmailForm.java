package forms;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

public class EmailForm {
	private String text;
	
	@NotBlank
	@Email
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
