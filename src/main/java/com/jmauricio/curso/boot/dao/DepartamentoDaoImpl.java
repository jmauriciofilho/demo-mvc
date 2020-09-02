package com.jmauricio.curso.boot.dao;

import com.jmauricio.curso.boot.domain.Departamento;
import org.springframework.stereotype.Repository;

@Repository
public class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDao{
}
