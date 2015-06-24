package com.adrianobrito.curso.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import static br.com.caelum.vraptor.view.Results.*;

import com.adrianobrito.curso.model.Noticia;
import com.adrianobrito.curso.service.NoticiaService;

@Controller
@Path("/noticias")
public class NoticiasController {

	@Inject private Result result;
	@Inject private NoticiaService noticiaService;
	
	@Post("/")
	@Consumes("application/json")
	public void add(Noticia noticia){
		noticiaService.save(noticia);
		result.use(status()).noContent();
	}
	
	@Get("/")
	public void list(){
		List<Noticia> noticias  = noticiaService.list();
		result.use(json()).withoutRoot().from(noticias).serialize();
	}
	
	@Get("/{noticia.id}")
	public void show(Noticia noticia){
		noticia = noticiaService.get(noticia.getId());
		result.use(json()).withoutRoot().from(noticia).serialize();
	}
	
	@Put("/{noticia.id}")
	@Consumes("application/json")
	public void update(Noticia noticia){
		noticiaService.update(noticia);
		result.use(status()).ok();
	}
	
	@Delete("/{noticia.id}")
	public void delete(Noticia noticia){
		noticiaService.delete(noticia);
		result.use(status()).ok();
	}
	
}