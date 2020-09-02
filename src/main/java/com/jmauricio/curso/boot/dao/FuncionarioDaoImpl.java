package com.jmauricio.curso.boot.dao;

import com.jmauricio.curso.boot.domain.Funcionario;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {
}
