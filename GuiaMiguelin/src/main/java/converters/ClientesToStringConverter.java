package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.*;


@Component
@Transactional
public class ClientesToStringConverter implements Converter<Clientes, String>{ 
	
	@Override
	public String convert(Clientes clientes) {
		String result;
		
		if(clientes == null){
			result = null;
		}else{
			result = String.valueOf(clientes.getId());
		}
		return result;
		
	}

}
