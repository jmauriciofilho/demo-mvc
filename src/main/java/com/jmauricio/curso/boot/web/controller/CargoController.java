package com.jmauricio.curso.boot.web.controller;

import com.jmauricio.curso.boot.domain.Cargo;
import com.jmauricio.curso.boot.domain.Departamento;
import com.jmauricio.curso.boot.service.CargoService;
import com.jmauricio.curso.boot.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/cadastrar")
    public String Cadastrar(Cargo cargo){
        return "/cargo/cadastro";
    }

    @GetMapping("/listar")
    public String Listar(ModelMap model){
        model.addAttribute("cargos", cargoService.buscarTodos());
        return "/cargo/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Cargo cargo, RedirectAttributes attr){
        cargoService.salvar(cargo);
        attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable Long id, ModelMap model){
        model.addAttribute("cargo", cargoService.buscarPorId(id));
        return "/cargo/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Cargo cargo, RedirectAttributes attr){
        cargoService.editar(cargo);
        attr.addFlashAttribute("success", "Cargo editado com sucesso.");
        return "redirect:/cargos/cadastrar";
    }

    @ModelAttribute("departamentos")
    public List<Departamento> listaDeDepartamentos(){
        return departamentoService.buscarTodos();
    }
}
