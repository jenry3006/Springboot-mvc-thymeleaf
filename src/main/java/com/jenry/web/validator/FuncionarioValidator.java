package com.jenry.web.validator;

import javax.validation.Validator;

import org.springframework.validation.Errors;

import com.jenry.domain.Funcionario;

public class FuncionarioValidator implements org.springframework.validation.Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		Funcionario f = (Funcionario) object;
		
		if(f.getDataSaida() != null) {
			if(f.getDataSaida().isBefore(f.getDataEntrada())) {
				errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
			}
		}
		
	}

}
