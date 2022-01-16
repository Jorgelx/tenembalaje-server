package com.server.tenembalaje.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String nombreEng;
    @ManyToOne(optional = false , fetch = FetchType.EAGER)
	private TipoProducto tipo;
	private float precio;
	private String descripcion;
	private String descripcionEng;
	private String img;
	private boolean enVenta;

	public Producto() {
		super();
	}

	public Producto(String nombre, String nombreEng, TipoProducto tipo, float precio, String descripcion,
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
	}

	public Producto(int id, String nombre, String nombreEng, TipoProducto tipo, float precio, String descripcion,
			String descripcionEng, String img, boolean enVenta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombreEng = nombreEng;
		this.tipo = tipo;
		this.precio = precio;
		this.descripcion = descripcion;
		this.descripcionEng = descripcionEng;
		this.img = img;
		this.enVenta = enVenta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public TipoProducto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProducto tipo) {
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

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", nombreEng=" + nombreEng + ", tipo=" + tipo + ", precio="
				+ precio + ", descripcion=" + descripcion + ", descripcionEng=" + descripcionEng + ", img=" + img
				+ ", enVenta=" + enVenta + "]";
	}

}
