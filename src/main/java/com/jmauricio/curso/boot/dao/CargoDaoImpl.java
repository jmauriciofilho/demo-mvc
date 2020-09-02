package com.jmauricio.curso.boot.dao;

import com.jmauricio.curso.boot.domain.Cargo;
import org.springframework.stereotype.Repository;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {
}
