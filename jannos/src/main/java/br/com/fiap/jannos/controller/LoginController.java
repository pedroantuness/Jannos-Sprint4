package br.com.fiap.jannos.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.jannos.model.Role;
import br.com.fiap.jannos.model.Usuario;
import br.com.fiap.jannos.repository.RoleRepository;
import br.com.fiap.jannos.repository.UsuarioRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioRepository repU;
	@Autowired
	private RoleRepository repR;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/index")
    public String retornaPagina() {
        return "index";
    }
	
	@GetMapping("/acesso_negado")
	public String acessoNegado() {
		return "acesso_negado";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/novo_usuario")
	public ModelAndView retornaCadUsuario() {
		ModelAndView mv = new ModelAndView("novo_usuario");
		mv.addObject("usuario", new Usuario());
		mv.addObject("roles", repR.findAll());
		return mv;	
	}
	
	@PostMapping("/inserir_usuario")
	public ModelAndView cadastrarUsuario(Usuario usuario, BindingResult bd, 
			@RequestParam(name = "id_role") Long id_role ) {
		
		if(bd.hasErrors()) {
			ModelAndView mv = new ModelAndView("novo_usuario");
			mv.addObject("usuario",usuario);
			mv.addObject("roles",repR.findAll());
			return mv;
		} else {
			
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			
			Set<Role> lista = new HashSet<>();
			
			
			if(id_role != null) {
				
				lista.add(repR.findById(id_role).orElse(null));
				
			}
			
			usuario.setRoles(lista);
			
			repU.save(usuario);
			
			return new ModelAndView("redirect:/index");
			
		}
		
		
	}
	
}
