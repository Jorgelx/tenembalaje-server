package com.server.tenembalaje.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import com.server.tenembalaje.dto.NoticiasDTO;
import com.server.tenembalaje.entity.Noticias;
import com.server.tenembalaje.service.NoticiasService;
import com.server.tenembalaje.utils.Mensaje;

@RestController
@RequestMapping("/noticias/")
@CrossOrigin
public class NoticiasController {

	@Autowired
	NoticiasService articuloService;

	@GetMapping("lista")
	public ResponseEntity<List<Noticias>> list() {
		List<Noticias> list = articuloService.list();
		return new ResponseEntity<List<Noticias>>(list, HttpStatus.OK);

	}

	@GetMapping("articulo/{id}")
	public ResponseEntity<NoticiasDTO> art(@PathVariable("id") int id) {
		Noticias a = articuloService.articulo(id).get();
		NoticiasDTO artDto = new NoticiasDTO(a.getTitulo(), a.getSubtitulo(), a.getTexto(), a.getImg());
		return new ResponseEntity<NoticiasDTO>(artDto, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "crear")
	public ResponseEntity<?> register(@RequestBody NoticiasDTO articulo) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		String fecha = formatter.format(date);
		Noticias art = new Noticias(articulo.getTitulo(), articulo.getSubtitulo(), articulo.getTexto(), fecha,
				articulo.getImg());
		articuloService.crear(art);
		return new ResponseEntity<>(new Mensaje("Noticia creada"), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("borrar/{id}")
	public ResponseEntity<?> borrar(@PathVariable("id") int id) {
		articuloService.borrar(id);
		return new ResponseEntity(new Mensaje("articulo borrado"), HttpStatus.OK);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("editar/{id}")
	public ResponseEntity<?> actualizar(@PathVariable("id") int id, @RequestBody NoticiasDTO articulo) {
		Noticias art = articuloService.articulo(id).get();
		art.setTitulo(articulo.getTitulo());
		art.setSubtitulo(articulo.getSubtitulo());
		art.setTexto(articulo.getTexto());
		art.setImg(articulo.getImg());
		articuloService.crear(art);
		return new ResponseEntity(new Mensaje("articulo creado"), HttpStatus.OK);

	}
}
