package com.server.tenembalaje.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.tenembalaje.dto.ProductoDTO;
import com.server.tenembalaje.entity.Producto;
import com.server.tenembalaje.entity.TipoProducto;
import com.server.tenembalaje.service.ProductoService;
import com.server.tenembalaje.service.TipoProductoService;
import com.server.tenembalaje.utils.Mensaje;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductoController {

	@Autowired
	ProductoService productService;

	@Autowired
	TipoProductoService tipoService;

	@GetMapping("list")
	public ResponseEntity<List<Producto>> list() {
		List<Producto> list = productService.list();
		return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/save")
	public ResponseEntity<?> crear(@RequestBody ProductoDTO productDTO) {
		System.out.println(productDTO.getDescripcionEng());
		if (StringUtils.isBlank(productDTO.getNombre()))
			return new ResponseEntity(new Mensaje("Se requiere un nombre"), HttpStatus.BAD_REQUEST);
		if (productDTO.getPrecio() <= 0)
			return new ResponseEntity(new Mensaje("Se requiere el precio"), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(productDTO.getNombreEng()))
			productDTO.setNombreEng(productDTO.getNombre());

		if (!tipoService.exist(productDTO.getTipo())) {

			
			TipoProducto tipo = new TipoProducto(productDTO.getTipo(), productDTO.getTipoEng());
			tipoService.save(tipo);
			Producto product = new Producto(productDTO.getNombre(), productDTO.getNombreEng(), tipo,
					productDTO.getPrecio(), productDTO.getDescripcion(), productDTO.getDescripcionEng(),
					productDTO.getImg(), productDTO.isEnVenta());

			productService.save(product);

			return new ResponseEntity(new Mensaje("Se ha creado un nuevo tipo de producto y un nuevo producto"),
					HttpStatus.OK);
		}

		TipoProducto tipo = tipoService.findByTipo(productDTO.getTipo());
		Producto product = new Producto(productDTO.getNombre(), productDTO.getNombreEng(), tipo, productDTO.getPrecio(),
				productDTO.getDescripcion(), productDTO.getDescripcionEng(), productDTO.getImg(),
				productDTO.isEnVenta());
		productService.save(product);
		return new ResponseEntity(new Mensaje("Producto creado"), HttpStatus.OK);

	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/tipo/{buscar}")
	public ResponseEntity<?> listTipo(@PathVariable("buscar") String buscar) {
		if (!tipoService.exist(buscar))
			return new ResponseEntity<Object>(new Mensaje("Este tipo de producto no existe"), HttpStatus.BAD_REQUEST);
		TipoProducto tipoProducto = tipoService.findByTipo(buscar);
		return new ResponseEntity(productService.getByTipo(tipoProducto), HttpStatus.OK);
	}


	@GetMapping("/tipos")
	public ResponseEntity<List<TipoProducto>> tipos() {
		return  new ResponseEntity<List<TipoProducto>>(tipoService.list(), HttpStatus.OK);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/delete/tipo/{id}")
	public ResponseEntity<Mensaje> borrarTipo(@PathVariable("id") int id) {
		TipoProducto tipo = tipoService.findById(id);
		productService.deleteTipo(tipo);
		tipoService.delete(id);
		return new ResponseEntity(new Mensaje("Producto eliminado"), HttpStatus.OK);
		
	}
}


