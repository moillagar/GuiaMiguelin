package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.*;


@Component
@Transactional
public class IncidenciaToStringConverter implements Converter<Incidencia, String>{ 
	
	@Override
	public String convert(Incidencia incidencia ) {
		String result;
		
		if(incidencia == null){
			result = null;
		}else{
			result = String.valueOf(incidencia.getId());
		}
		return result;
		
	}

}
