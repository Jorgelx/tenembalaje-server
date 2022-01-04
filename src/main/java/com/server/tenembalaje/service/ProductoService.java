package com.server.tenembalaje.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.tenembalaje.entity.Producto;
import com.server.tenembalaje.repository.ProductoRepository;

@Service
@Transactional
public class ProductoService {

	@Autowired
	ProductoRepository productRepository;
	
	public List<Producto> list() {
		return productRepository.findAll();
	}
	
	public Optional<Producto> get(int id) {
		return productRepository.findById(id);
	}
	
	public void save(Producto product) {
		productRepository.save(product);
	}
	
	public boolean exist(int id) {
		return productRepository.existsById(id);
	}
	
	public Optional<List<Producto>> getByTipo(String tipo) {
		return productRepository.findByTipo(tipo);
	}
}
