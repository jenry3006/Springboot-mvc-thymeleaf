package com.jenry.service;

import java.util.List;

import com.jenry.domain.Funcionario;

public interface FuncionarioService {

void salvar (Funcionario funcionario);
	
	void editar(Funcionario funcionario);
	
	void excluir(Long id);
	
	Funcionario buscarPorId(Long id);
	
	List<Funcionario> buscaTodos();
}
