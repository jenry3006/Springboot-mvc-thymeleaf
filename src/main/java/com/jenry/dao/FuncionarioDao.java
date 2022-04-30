package com.jenry.dao;

import java.time.LocalDate;
import java.util.List;

import com.jenry.domain.Funcionario;

public interface FuncionarioDao {

	void save (Funcionario funcionario);
	
	void update(Funcionario funcionario);
	
	void delete(Long id);
	
	Funcionario findById(Long id);
	
	List<Funcionario> findAll();
	
	List<Funcionario> findByName(String nome);

	List<Funcionario> findByCargo(Long id);

	List<Funcionario> findByEntradaSaida(LocalDate entrada, LocalDate saida);

	List<Funcionario> findByDataEntrada(LocalDate entrada);

	List<Funcionario> findByDataSaida(LocalDate saida);
}
