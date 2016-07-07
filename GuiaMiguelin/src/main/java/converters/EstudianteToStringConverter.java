package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.*;


@Component
@Transactional
public class EstudianteToStringConverter implements Converter<Estudiante, String>{ 
	
	@Override
	public String convert(Estudiante estudiante ) {
		String result;
		
		if(estudiante == null){
			result = null;
		}else{
			result = String.valueOf(estudiante.getId());
		}
		return result;
		
	}

}
