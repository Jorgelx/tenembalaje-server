package com.server.tenembalaje.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.tenembalaje.dto.ProductoDTO;
import com.server.tenembalaje.entity.Producto;
import com.server.tenembalaje.service.ProductoService;
import com.server.tenembalaje.utils.Mensaje;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductoController {

	@Autowired
	ProductoService productService;

	@GetMapping("list")
	public ResponseEntity<List<Producto>> list() {
		List<Producto> list = productService.list();
		return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/save")
	public ResponseEntity<?> crear(@RequestBody ProductoDTO productDTO) {
		if (StringUtils.isBlank(productDTO.getNombre()))
			return new ResponseEntity(new Mensaje("Name required"), HttpStatus.BAD_REQUEST);
		if (productDTO.getPrecio() <= 0)
			return new ResponseEntity(new Mensaje("Price required"), HttpStatus.BAD_REQUEST);
		if (StringUtils.isBlank(productDTO.getNombreEng()))
			productDTO.setNombreEng(productDTO.getNombre());

		Producto product = new Producto(productDTO.getNombre(), productDTO.getNombreEng(), productDTO.getTipo(),
				productDTO.getPrecio(), productDTO.getDescripcion(), productDTO.getDescripcionEng(),
				productDTO.getImg(), productDTO.isEnVenta());
		productService.save(product);
		return new ResponseEntity(new Mensaje("Product created"), HttpStatus.OK);
	}

}
