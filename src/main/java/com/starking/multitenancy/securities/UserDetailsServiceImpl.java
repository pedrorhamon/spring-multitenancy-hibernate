package com.starking.multitenancy.securities;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.starking.multitenancy.models.Usuario;
import com.starking.multitenancy.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(s);
		return usuario.map(UserDetailsImpl::new).orElse(null);
	}
}