package com.server.tenembalaje.dto;

public class NoticiasDTO {

	private String titulo;
	private String tituloEng;
	private String subtitulo;
	private String subtituloEng;
	private String texto;
	private String textoEng;
	private String img;
	private String fecha;

	public NoticiasDTO() {
		super();
	}

	
	public NoticiasDTO(String titulo, String tituloEng, String subtitulo, String subtituloEng, String texto,
			String textoEng, String img) {
		super();
		this.titulo = titulo;
		this.tituloEng = tituloEng;
		this.subtitulo = subtitulo;
		this.subtituloEng = subtituloEng;
		this.texto = texto;
		this.textoEng = textoEng;
		this.img = img;
	}

	
	public NoticiasDTO(String titulo, String tituloEng, String subtitulo, String subtituloEng, String texto,
			String textoEng, String img, String fecha) {
		super();
		this.titulo = titulo;
		this.tituloEng = tituloEng;
		this.subtitulo = subtitulo;
		this.subtituloEng = subtituloEng;
		this.texto = texto;
		this.textoEng = textoEng;
		this.img = img;
		this.fecha = fecha;
	}




	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
