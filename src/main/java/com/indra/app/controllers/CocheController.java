package com.indra.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indra.app.models.entity.Coche;
import com.indra.app.service.CocheService;

import java.util.Optional;

@Controller //marcamos y configuramos la clase como controlador
@RequestMapping({"/","/coches","/index"}) //para específicar varias rutas a parte de root /
public class CocheController {
    @Autowired //realiza la inyeccion de dependencias, añade al contexto de Spring
    private CocheService cocheService; //uso de la clase service
    

    // Método para listar todos los coches
    @GetMapping("/listar")
    public String listarCoches(Model model) {
    	// Obtener la lista de coches desde el servicio
        model.addAttribute("coches", cocheService.obtenerTodosLosCoches());
       // Devolver el nombre de la vista para mostrar la lista de coches
        return "listarCoches";
    }
    
    // Método para mostrar el formulario de creación o edición de coches
    @GetMapping("/form")
    public String mostrarFormulario(@RequestParam(required = false) Long id, Model model) {
    	// Crear un nuevo objeto Coche para el formulario
        Coche coche = new Coche();
        // Si se proporciona un ID, intentar cargar el coche correspondiente
        if (id != null) {
        	// Obtener el coche por su ID desde el servicio
            Optional<Coche> optionalCoche = cocheService.obtenerCochePorId(id);
         // Si el coche existe, asignarlo al objeto coche
            if (optionalCoche.isPresent()) {
                coche = optionalCoche.get();
            }
        }
        // Agregar el objeto Coche al modelo para mostrarlo en el formulario
        model.addAttribute("coche", coche);
        // Devolver el nombre de la vista del formulario
        return "formularioCoche";
    }
    // Método para guardar un coche (tanto creación como edición)
    @PostMapping("/form")
    public String guardarCoche(@ModelAttribute("coche") Coche coche) {
    	// Guardar el coche utilizando el servicio
        cocheService.guardarCoche(coche);
     // Redirigir a la página de listar coches después de guardar
        return "redirect:/coches/listar";
    }
    // Método para eliminar un coche por su ID
    @GetMapping("/eliminar/{id}")
    public String eliminarCoche(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    	// Eliminar el coche por su ID utilizando el servicio
        cocheService.eliminarCoche(id);
        // Redirigir a la página de listar coches después de eliminar
        return "redirect:/coches/listar";
    }
}
/*
 * Capa de Presentación (Controller)
 * En esta capa, manejamos la interacción con el usuario
 */


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

