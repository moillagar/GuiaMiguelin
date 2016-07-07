package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import repositories.*;
import domain.Oferta;


@Component
@Transactional
public class StringToOfertaConverter implements Converter<String, Oferta>{
	 @Autowired OfertaRepository ofertaRepository;

	@Override
	public Oferta convert(String text) {
		Oferta result;
		int id;
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id=Integer.valueOf(text);
				result = ofertaRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		return result;
		
	}



}
