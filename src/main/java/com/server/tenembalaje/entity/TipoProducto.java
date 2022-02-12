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
	String tipoEng;

	public TipoProducto(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.tipo = tipoEng;
	}

	public TipoProducto(String tipo, String tipoEng) {
		super();
		this.tipo = tipo;
		this.tipoEng = tipoEng;
	}

	public TipoProducto() {
		super();
	}

	public String getTipoEng() {
		return tipoEng;
	}

	public void setTipoEng(String tipoEng) {
		this.tipoEng = tipoEng;
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
