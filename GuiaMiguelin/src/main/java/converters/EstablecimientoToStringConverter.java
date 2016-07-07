package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.*;


@Component
@Transactional
public class EstablecimientoToStringConverter implements Converter<Establecimiento, String>{ 
	
	@Override
	public String convert(Establecimiento establecimiento ) {
		String result;
		
		if(establecimiento == null){
			result = null;
		}else{
			result = String.valueOf(establecimiento.getId());
		}
		return result;
		
	}

}
