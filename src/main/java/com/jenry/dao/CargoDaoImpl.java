package com.jenry.dao;

import org.springframework.stereotype.Repository;

import com.jenry.domain.Cargo;

@Repository
public abstract class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {

}