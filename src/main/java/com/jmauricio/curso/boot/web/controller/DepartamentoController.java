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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String listar(ModelMap model){
        model.addAttribute("departamentos", service.buscarTodos());
        return "/departamento/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Departamento departamento, RedirectAttributes attr){
        service.salvar(departamento);
        attr.addFlashAttribute("success", "Departamento editado com sucesso.");
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable Long id, ModelMap model){
        model.addAttribute("departamento", service.buscarPorId(id));
        return "/departamento/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Departamento departamento, RedirectAttributes attr){
        service.editar(departamento);
        attr.addFlashAttribute("success", "Departamento editado com sucesso.");
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        if (service.departamentoTemCargo(id)){
            model.addAttribute("fail", "Departamento não removido. Possui cargo(s) vinculado(s).");
        }

        service.excluir(id);
        model.addAttribute("fail", "Departamento excluido com sucesso.");

        return listar(model);
    }
}
