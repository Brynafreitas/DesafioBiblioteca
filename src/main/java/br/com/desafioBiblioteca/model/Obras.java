package br.com.desafioBiblioteca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity	
@Table(name = "obras")
public class Obras {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String titulo;
	
	@NotNull
	private String editora;
	
	@NotNull
	private String foto;
	
	@NotNull
	private String autores;
	
	

	public String getTitulo() {
		return titulo;
	}

	public String getEditora() {
		return editora;
	}

	public String getFoto() {
		return foto;
	}

	public String getAutores() {
		return autores;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
}
