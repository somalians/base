package com.adrianobrito.curso.model;

import java.util.Date;

public class Noticia {
	
	private Integer id;
	private String titulo;
	private String conteudo;
	private Date publicacao;
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
	public String getTitulo() { return titulo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }
	
	public String getConteudo() { return conteudo; }
	public void setConteudo(String conteudo) { this.conteudo = conteudo; }
	
	public Date getPublicacao() { return publicacao; }
	public void setPublicacao(Date publicacao) { this.publicacao = publicacao; }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noticia other = (Noticia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
