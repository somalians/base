package com.adrianobrito.curso.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import com.adrianobrito.curso.model.Noticia;

@RequestScoped
public class NoticiaService {
	
	private static List<Noticia> noticias = new ArrayList<Noticia>();
	
	public void save(Noticia noticia){
		Integer id = noticias.size();
		noticia.setId(id);
		noticia.setPublicacao(new Date());
		noticias.add(noticia);
	}
	
	public void update(Noticia noticia){
		Noticia noticiaAtualizacao = noticias.get(noticia.getId());
		noticiaAtualizacao.setConteudo(noticia.getConteudo());
		noticiaAtualizacao.setTitulo(noticia.getTitulo());
	}
	
	public Noticia get(Integer id){
		return noticias.get(id);
	}
	
	public List<Noticia> list(){
		return noticias;
	}
	
	public void delete(Noticia noticia){
		noticias.remove(noticia.getId().intValue());
	}
	
}
