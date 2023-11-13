package com.indra.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.indra.app.models.entity.Coche;
import com.indra.app.service.CocheService;

@Controller
@RequestMapping("/coches")
public class CocheController {
    @Autowired
    private CocheService cocheService;

    @GetMapping("/listar")
    public String listarCoches(Model model) {
        model.addAttribute("coches", cocheService.obtenerTodosLosCoches());
        return "listarCoches";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Coche coche, Model model) {
        model.addAttribute("coche", coche);
        return "formularioCoche";
    }

    @PostMapping("/form")
    public String guardarCoche(@ModelAttribute("coche") Coche coche) {
        cocheService.guardarCoche(coche);
        return "redirect:/coches/listar";
    }
}
