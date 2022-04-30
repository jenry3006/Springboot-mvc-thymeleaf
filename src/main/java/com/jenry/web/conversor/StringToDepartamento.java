package com.jenry.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jenry.domain.Departamento;
import com.jenry.service.DepartamentoService;

@Component
public class StringToDepartamento implements Converter<String, Departamento> {

	@Autowired
	private DepartamentoService service;
	
	@Override
	public Departamento convert(String texto) {
		if(texto.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(texto);
		return service.buscarPorId(id);
	}
	

}
