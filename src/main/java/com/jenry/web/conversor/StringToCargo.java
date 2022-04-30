package com.jenry.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jenry.domain.Cargo;
import com.jenry.service.CargoService;

@Component
public class StringToCargo implements Converter<String, Cargo>{

	@Autowired
	private CargoService cargoService;
	
	@Override
	public Cargo convert(String texto) {
		if(texto.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(texto);
		return cargoService.buscarPorId(id);
	}

}
