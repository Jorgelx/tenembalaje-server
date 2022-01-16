package com.server.tenembalaje.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.tenembalaje.entity.TipoProducto;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Integer> {

	Optional<TipoProducto> findByTipo(String tipo);
	Boolean existsByTipo(String tipo);
}
