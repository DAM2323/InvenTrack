package com.inventrack.inventrack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventrack.inventrack.entity.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

    Optional<Inventario> findBySucursal_IdAndProducto_Id(Integer idSucursal, Integer idProducto);
}
