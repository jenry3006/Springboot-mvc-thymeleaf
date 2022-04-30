package com.jenry.dao;

import java.util.List;

import com.jenry.domain.Cargo;
import com.jenry.util.PaginacaoUtil;

public interface CargoDao {
	
	void save (Cargo cargo);
	
	void update(Cargo cargo);
	
	void delete(Long id);
	
	Cargo findById(Long id);
	
	List<Cargo> findAll();
	
	PaginacaoUtil<Cargo> buscaPaginada(int pagina);
}
