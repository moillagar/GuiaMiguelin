package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import repositories.*;
import domain.Proveedor;


@Component
@Transactional
public class StringToProveedorConverter implements Converter<String, Proveedor>{
	 @Autowired ProveedorRepository proveedorRepository;

	@Override
	public Proveedor convert(String text) {
		Proveedor result;
		int id;
		try{
			if(StringUtils.isEmpty(text))
				result = null;
			else{
				id=Integer.valueOf(text);
				result = proveedorRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		return result;
		
	}

}
