package com.starking.multitenancy.configs;

import javax.persistence.EntityManager;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

import com.starking.multitenancy.securities.UserDetailsImpl;

@Aspect
@Configuration
public class FiltroUsuarioAspecto {

	@Autowired
	EntityManager entityManager;

	@Before(value = ("execution(* com.starking.controllers.*.*(..))"))
	public void setFiltroUsuario() {
		long codigoUsuario = ((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUsuario().getCodigo();

		Session sessao = entityManager.unwrap(Session.class);
		sessao.enableFilter("usuario").setParameter("codigousuario", codigoUsuario);
	}
}