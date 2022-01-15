package com.server.tenembalaje.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.server.tenembalaje.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	Optional<List<Producto>> findByTipo(String tipo);
}
