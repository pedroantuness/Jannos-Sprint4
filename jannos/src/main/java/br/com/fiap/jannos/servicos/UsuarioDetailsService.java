package br.com.fiap.jannos.servicos;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.jannos.model.Usuario;
import br.com.fiap.jannos.repository.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repU;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario user = repU.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
		
		return new User(user.getUsername(), user.getPassword(), 
				user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNome())).collect(Collectors.toList()));
	}
	
}
