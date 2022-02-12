package com.server.tenembalaje.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.tenembalaje.entity.TipoProducto;
import com.server.tenembalaje.security.repository.TipoProductoRepository;

@Service
@Transactional
public class TipoProductoService {
	
	@Autowired
	TipoProductoRepository tipoRepository;
	
	public List<TipoProducto> list() {
		return tipoRepository.findAll();
	}
	
	
	public void save(TipoProducto tipoProducto){
		tipoRepository.saveAndFlush(tipoProducto);
	}
	
	
	public TipoProducto findByTipo(String tipo) {
		return tipoRepository.findByTipo(tipo).get();
	}
	
	public TipoProducto findById(int id) {
		return tipoRepository.findById(id).get();
	}
	
	public boolean exist(String tipo) {
		return tipoRepository.existsByTipo(tipo);
	}
	
	public void delete(int id) {
		tipoRepository.deleteById(id);
	}
	public void deleteByTipo(int id) {
		tipoRepository.deleteById(id);
	}
}
