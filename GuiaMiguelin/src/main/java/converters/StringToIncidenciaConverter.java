package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import repositories.*;
import domain.Incidencia;


@Component
@Transactional
public class StringToIncidenciaConverter implements Converter<String, Incidencia>{
	 @Autowired IncidenciaRepository incidenciaRepository;

	@Override
	public Incidencia convert(String text) {
		Incidencia result;
		int id;
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id=Integer.valueOf(text);
				result = incidenciaRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		return result;
		
	}


}
