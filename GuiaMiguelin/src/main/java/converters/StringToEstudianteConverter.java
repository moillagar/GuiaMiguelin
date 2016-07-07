package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import repositories.*;
import domain.Estudiante;


@Component
@Transactional
public class StringToEstudianteConverter implements Converter<String, Estudiante>{
	 @Autowired EstudianteRepository estudianteRepository;

	@Override
	public Estudiante convert(String text) {
		Estudiante result;
		int id;
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id=Integer.valueOf(text);
				result = estudianteRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		return result;
		
	}

}
