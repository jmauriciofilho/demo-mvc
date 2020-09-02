package com.jmauricio.curso.boot.web.controller;

import com.jmauricio.curso.boot.domain.Departamento;
import com.jmauricio.curso.boot.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping("/cadastrar")
    public String Cadastrar(Departamento departamento){
        return "/departamento/cadastro";
    }

    @GetMapping("/listar")
    public String Listar(){
        return "/departamento/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Departamento departamento){
        service.salvar(departamento);
        return "redirect:/departamentos/cadastrar";
    }
}
