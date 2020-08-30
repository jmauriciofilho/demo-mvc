package com.jmauricio.curso.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @GetMapping("/cadastrar")
    public String Cadastrar(){
        return "/departamento/cadastro";
    }

    @GetMapping("/listar")
    public String Listar(){
        return "/departamento/lista";
    }
}
