package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import repositories.CalificacionOfertaRepository;
import domain.CalificacionOferta;

@Component
@Transactional
public class StringToCalificacionOfertaConverter implements Converter<String, CalificacionOferta>{
	 @Autowired CalificacionOfertaRepository calificacionOfertaRepository;

	@Override
	public CalificacionOferta convert(String text) {
		CalificacionOferta result;
		int id;
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id=Integer.valueOf(text);
				result = calificacionOfertaRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		return result;
		
	}

}
