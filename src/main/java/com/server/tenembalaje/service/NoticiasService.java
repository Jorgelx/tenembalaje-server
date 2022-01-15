package com.server.tenembalaje.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.tenembalaje.entity.Noticias;
import com.server.tenembalaje.repository.NoticiasRepository;

@Service
@Transactional
public class NoticiasService {

	@Autowired
	NoticiasRepository articuloRepository;

	public List<Noticias> list() {
		return articuloRepository.findAll();
	}

	public Optional<Noticias> articulo(int id) {
		return articuloRepository.findById(id);
	}

	public void crear(Noticias articulo) {
		articuloRepository.save(articulo);
	}

	public void borrar(int id) {
		articuloRepository.deleteById(id);
	}

}
