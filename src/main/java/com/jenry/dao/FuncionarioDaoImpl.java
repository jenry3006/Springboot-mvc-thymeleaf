package com.jenry.dao;

import org.springframework.stereotype.Repository;

import com.jenry.domain.Funcionario;

@Repository
public abstract class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao{

}
