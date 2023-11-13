package com.indra.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indra.app.models.entity.Coche;
import com.indra.app.service.CocheService;

import java.util.Optional;

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
    public String mostrarFormulario(@RequestParam(required = false) Long id, Model model) {
        Coche coche = new Coche();
        if (id != null) {
            Optional<Coche> optionalCoche = cocheService.obtenerCochePorId(id);
            if (optionalCoche.isPresent()) {
                coche = optionalCoche.get();
            }
        }
        model.addAttribute("coche", coche);
        return "formularioCoche";
    }

    @PostMapping("/form")
    public String guardarCoche(@ModelAttribute("coche") Coche coche) {
        cocheService.guardarCoche(coche);
        return "redirect:/coches/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCoche(@PathVariable Long id, RedirectAttributes redirectAttributes) {   
            cocheService.eliminarCoche(id);
        return "redirect:/coches/listar";
    }
}



//    @GetMapping("/eliminar/{id}")
//    public String eliminarCoche(@PathVariable Long id, RedirectAttributes redirectAttributes) {
//       try {
//           cocheService.eliminarCoche(id);
//            redirectAttributes.addFlashAttribute("mensaje", "Coche eliminado correctamente");
//        } catch (Exception e) {
//            redirectAttributes.addFlashAttribute("error", "Error al eliminar el coche: " + e.getMessage());
//        }
//        return "redirect:/coches/listar";
//    }
//}

