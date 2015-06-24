package com.adrianobrito.curso.infra;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Options;
import br.com.caelum.vraptor.Result;
import static br.com.caelum.vraptor.view.Results.*;

@Controller
public class OptionsController {

	@Inject private Result result;
	
	@Options("/*")
	public void options(){
		result.use(status()).noContent();
	}
	
}