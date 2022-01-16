package com.server.tenembalaje.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String tipo;

	public TipoProducto(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	public TipoProducto(String tipo) {
		super();
		this.tipo = tipo;
	}

	public TipoProducto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "TipoProducto [id=" + id + ", tipo=" + tipo + "]";
	}

}
