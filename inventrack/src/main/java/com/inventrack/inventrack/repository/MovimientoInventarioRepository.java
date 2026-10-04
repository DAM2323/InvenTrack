package com.inventrack.inventrack.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.inventrack.inventrack.entity.MovimientoInventario;

public interface MovimientoInventarioRepository extends JpaRepository<MovimientoInventario, Integer> {
}
