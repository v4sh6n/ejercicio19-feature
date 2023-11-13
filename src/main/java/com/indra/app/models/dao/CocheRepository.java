package com.indra.app.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.app.models.entity.Coche;

public interface CocheRepository extends JpaRepository<Coche, Long> {
    // Puedes agregar métodos personalizados si es necesario
}
