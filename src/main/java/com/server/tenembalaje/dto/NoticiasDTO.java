package com.server.tenembalaje.dto;

public class NoticiasDTO {

	private String titulo;
	private String subtitulo;
	private String texto;
	private String img;

	public NoticiasDTO() {
		super();
	}

	public NoticiasDTO(String titulo, String subtitulo, String texto, String img) {
		super();
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.texto = texto;
		this.img = img;
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
