package com.jenry.service;

import java.util.List;

import com.jenry.domain.Cargo;
import com.jenry.util.PaginacaoUtil;

public interface CargoService {
	
	void salvar (Cargo cargo);
	
	void editar(Cargo cargo);
	
	void excluir(Long id);
	
	Cargo buscarPorId(Long id);
	
	List<Cargo> buscarTodos();

	boolean cargoContemFuncionario(Long id);
	
	PaginacaoUtil<Cargo> buscarPorPagina(int pagina);

}
