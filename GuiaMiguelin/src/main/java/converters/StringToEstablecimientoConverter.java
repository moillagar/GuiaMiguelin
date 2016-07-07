package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import repositories.*;
import domain.Establecimiento;


@Component
@Transactional
public class StringToEstablecimientoConverter implements Converter<String, Establecimiento>{
	 @Autowired EstablecimientoRepository establecimientoRepository;

	@Override
	public Establecimiento convert(String text) {
		Establecimiento result;
		int id;
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id=Integer.valueOf(text);
				result = establecimientoRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		return result;
		
	}

}
