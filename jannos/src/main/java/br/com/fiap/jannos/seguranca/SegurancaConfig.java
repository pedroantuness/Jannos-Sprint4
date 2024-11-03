package br.com.fiap.jannos.seguranca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SegurancaConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.
		authorizeHttpRequests((requests) -> requests. requestMatchers(
				"/cadastro_endereco", "/atualiza_endereco/{id}","/remover_endereco/{id}", 
				"/cadastro_nota", "/atualiza_nota/{id}", "/remover_nota/{id}", 
				"/cadastro_produto", "/atualiza_produto/{id}", "/remover_produto/{id}").hasAuthority("ROLE_ADMIN")
				.anyRequest().authenticated())
			.formLogin((form) -> form.loginPage("/login")
					.defaultSuccessUrl("/index").failureUrl("/login?falha=true").permitAll())
			.logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout=true").permitAll())
			.exceptionHandling((exception) -> 
			exception.accessDeniedHandler(
					(request,response,AccessDeniedException) -> {response.sendRedirect("/acesso_negado");}));
		
		return http.build();
		
	}
	
	
	 @Bean 
	 public PasswordEncoder passwordEncoder() { 
		 return new BCryptPasswordEncoder(); 
	 }

}
