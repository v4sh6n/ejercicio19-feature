package com.indra.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.app.models.dao.CocheRepository;
import com.indra.app.models.entity.Coche;

import java.util.List;
import java.util.Optional;

@Service
public class CocheService {
    @Autowired
    private CocheRepository cocheRepository;

    public List<Coche> obtenerTodosLosCoches() {
        return cocheRepository.findAll();
    }

    public Optional<Coche> obtenerCochePorId(Long id) {
        return cocheRepository.findById(id);
    }

    public void guardarCoche(Coche coche) {
        cocheRepository.save(coche);
    }

    public void eliminarCoche(Long id) {
        cocheRepository.deleteById(id);
    }
}
/*
 * Capa de Servicio (Service):
 *  capa de servicio contiene la lógica de negocio de la aplicación
 *  Los servicios se encargan de realizar operaciones específicas relacionadas con los coches, 
 * La clase CocheService es un componente de servicio con la anotación @Service.
 * Utiliza la inyección de dependencias para acceder a un CocheRepository.
 * Proporciona métodos para operaciones lógicas relacionadas con coches
 * 
 * 
 * 
 * 
 */
