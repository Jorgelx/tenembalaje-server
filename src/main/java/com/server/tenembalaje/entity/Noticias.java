package com.server.tenembalaje.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Noticias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private String tituloEng;
	private String subtitulo;
	private String subtituloEng;
	@Lob
	private String texto;
	private String textoEng;
	private String fecha;

	private String img;

	public Noticias() {
		super();
	}


	
	public Noticias(String titulo, String tituloEng, String subtitulo, String subtituloEng, String texto,
			String textoEng, String fecha, String img) {
		super();
		this.titulo = titulo;
		this.tituloEng = tituloEng;
		this.subtitulo = subtitulo;
		this.subtituloEng = subtituloEng;
		this.texto = texto;
		this.textoEng = textoEng;
		this.fecha = fecha;
		this.img = img;
	}



	public Noticias(int id, String titulo, String tituloEng, String subtitulo, String subtituloEng, String texto,
			String textoEng, String fecha, String img) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.tituloEng = tituloEng;
		this.subtitulo = subtitulo;
		this.subtituloEng = subtituloEng;
		this.texto = texto;
		this.textoEng = textoEng;
		this.fecha = fecha;
		this.img = img;
	}


	public String getTituloEng() {
		return tituloEng;
	}


	public void setTituloEng(String tituloEng) {
		this.tituloEng = tituloEng;
	}


	public String getSubtituloEng() {
		return subtituloEng;
	}


	public void setSubtituloEng(String subtituloEng) {
		this.subtituloEng = subtituloEng;
	}


	public String getTextoEng() {
		return textoEng;
	}


	public void setTextoEng(String textoEng) {
		this.textoEng = textoEng;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Noticias [id=" + id + ", titulo=" + titulo + ", tituloEng=" + tituloEng + ", subtitulo=" + subtitulo
				+ ", subtituloEng=" + subtituloEng + ", texto=" + texto + ", textoEng=" + textoEng + ", fecha=" + fecha
				+ ", img=" + img + "]";
	}

}
