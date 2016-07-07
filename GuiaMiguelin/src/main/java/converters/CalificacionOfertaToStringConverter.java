package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.*;


@Component
@Transactional
public class CalificacionOfertaToStringConverter implements Converter<CalificacionOferta, String>{ 
	
	@Override
	public String convert(CalificacionOferta calificacionOferta ) {
		String result;
		
		if(calificacionOferta == null){
			result = null;
		}else{
			result = String.valueOf(calificacionOferta.getId());
		}
		return result;
		
	}

}
