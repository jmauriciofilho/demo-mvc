package com.jmauricio.curso.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cargos")
public class CargoController {

    @GetMapping("/cadastrar")
    public String Cadastrar(){
        return "/cargo/cadastro";
    }

    @GetMapping("/listar")
    public String Listar(){
        return "/cargo/lista";
    }
}
