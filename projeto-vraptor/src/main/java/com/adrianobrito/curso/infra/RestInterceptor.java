package com.adrianobrito.curso.infra;

import javax.inject.Inject;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.view.Results;

@Intercepts
public class RestInterceptor implements Interceptor{

	@Inject private Result result;
	
	@Override
	public boolean accepts(ControllerMethod controllerMethod) {
		return true;
	}

	@Override
	public void intercept(InterceptorStack stack, ControllerMethod controllerMethod,
			Object resource) throws InterceptionException {

		result.use(Results.http()).addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE, PUT");
		result.use(Results.http()).addHeader("Access-Control-Allow-Origin", "*");
		result.use(Results.http()).addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		
		try { 
            stack.next(controllerMethod, resource);  
        } catch (Exception ex) {  
        	result.use(Results.http()).body(ex.getMessage()).setStatusCode(500);
        }
	}

}
