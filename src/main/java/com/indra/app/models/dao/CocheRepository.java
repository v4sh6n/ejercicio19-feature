package com.indra.app.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indra.app.models.entity.Coche;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {
    // Puedes agregar métodos personalizados si es necesario
}
