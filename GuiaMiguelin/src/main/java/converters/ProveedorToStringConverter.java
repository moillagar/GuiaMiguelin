package converters;

import org.springframework.core.convert.converter.Converter;

import domain.*;

public class ProveedorToStringConverter implements Converter<Proveedor, String>{ 
	
	@Override
	public String convert(Proveedor proveedor ) {
		String result;
		
		if(proveedor == null){
			result = null;
		}else{
			result = String.valueOf(proveedor.getId());
		}
		return result;
		
	}

}
