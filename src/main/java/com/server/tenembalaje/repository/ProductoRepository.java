package com.server.tenembalaje.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.server.tenembalaje.entity.Producto;
import com.server.tenembalaje.entity.TipoProducto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	Optional<List<Producto>> findByTipo(TipoProducto tipo);
	void deleteByTipo(TipoProducto tipo);
}
