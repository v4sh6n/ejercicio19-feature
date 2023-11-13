package com.indra.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.app.models.dao.CocheRepository;
import com.indra.app.models.entity.Coche;

import java.util.List;

@Service
public class CocheService {
    @Autowired
    private CocheRepository cocheRepository;

    public List<Coche> obtenerTodosLosCoches() {
        return cocheRepository.findAll();
    }

    public void guardarCoche(Coche coche) {
        cocheRepository.save(coche);
    }
}
