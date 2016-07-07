package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.*;


@Component
@Transactional
public class OfertaToStringConverter implements Converter<Oferta, String>{ 
	
	@Override
	public String convert(Oferta oferta ) {
		String result;
		
		if(oferta == null){
			result = null;
		}else{
			result = String.valueOf(oferta.getId());
		}
		return result;
		
	}

}
