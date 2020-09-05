package com.jmauricio.curso.boot.web.controller;

import com.jmauricio.curso.boot.domain.Departamento;
import com.jmauricio.curso.boot.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String Listar(ModelMap model){
        model.addAttribute("departamentos", service.buscarTodos());
        return "/departamento/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Departamento departamento){
        service.salvar(departamento);
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable Long id, ModelMap model){
        model.addAttribute("departamento", service.buscarPorId(id));
        return "/departamento/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Departamento departamento){
        service.editar(departamento);
        return "redirect:/departamentos/cadastrar";
    }
}
