package com.jenry.service;

import java.util.List;

import com.jenry.domain.Departamento;

public interface DepartamentoService {

	void salvar (Departamento departamento);
	
	void editar(Departamento departamento);
	
	void excluir(Long id);
	
	Departamento buscarPorId(Long id);
	
	List<Departamento> buscaTodos();

	boolean departamentoContemCargo(Long id);
}
