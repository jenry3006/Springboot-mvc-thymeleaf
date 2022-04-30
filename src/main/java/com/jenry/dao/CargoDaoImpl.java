package com.jenry.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jenry.domain.Cargo;
import com.jenry.util.PaginacaoUtil;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {
	
	public PaginacaoUtil<Cargo> buscaPaginada(int pagina) {
		
		int tamanho = 5;
		int inicio = (pagina - 1) * tamanho;
		
		List<Cargo> cargos = getEntityManager()
				.createQuery("select c from Cargo c order by c.nome asc", Cargo.class)
				.setFirstResult(inicio)
				.setMaxResults(tamanho)
				.getResultList();
		
		long totalRegistros = count();
		long totalPaginas = (totalRegistros + (tamanho - 1) / tamanho);
		
		return new PaginacaoUtil<>(tamanho, pagina, totalPaginas, cargos);
	}
	
	public long count() {
		return getEntityManager()
				.createQuery("select count (*) from Cargo", Long.class)
				.getSingleResult();
	}

}
