package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import repositories.ClientesRepository;
import domain.Clientes;

@Component
@Transactional
public class StringToClientesConverter implements Converter<String, Clientes>{
	 @Autowired ClientesRepository clientesRepository;

	@Override
	public Clientes convert(String text) {
		Clientes result;
		int id;
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id=Integer.valueOf(text);
				result = clientesRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		return result;
		
	}

}
