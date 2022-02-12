package com.server.tenembalaje.dto;

public class ProductoDTO {

	private String nombre;
	private String nombreEng;
	private String tipo;
	private String tipoEng;
	private float precio;
	private String descripcion;
	private String descripcionEng;
	private String img;
	private boolean enVenta;
	
	public ProductoDTO() {
		super();
	}

	
	public ProductoDTO(String nombre, float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}



	public ProductoDTO(String nombre, String nombreEng, String tipo ,String tipoEng, float precio, String descripcion,
			String descripcionEng, String img, boolean enVenta) {
		super();
		this.nombre = nombre;
		this.nombreEng = nombreEng;
		this.tipo = tipo;
		this.precio = precio;
		this.descripcion = descripcion;
		this.descripcionEng = descripcionEng;
		this.img = img;
		this.enVenta = enVenta;
		this.tipoEng = tipoEng;
	}

	public String getTipoEng() {
		return tipoEng;
	}


	public void setTipoEng(String tipoEng) {
		this.tipoEng = tipoEng;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreEng() {
		return nombreEng;
	}

	public void setNombreEng(String nombreEng) {
		this.nombreEng = nombreEng;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionEng() {
		return descripcionEng;
	}

	public void setDescripcionEng(String descripcionEng) {
		this.descripcionEng = descripcionEng;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public boolean isEnVenta() {
		return enVenta;
	}

	public void setEnVenta(boolean enVenta) {
		this.enVenta = enVenta;
	}
	
	
}
