package br.com.fiap.jannos.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_role_tab", 
	joinColumns = @JoinColumn(name = "id_usuario"), 
	inverseJoinColumns = @JoinColumn(name = "id_role"))
	private Set<Role> roles = new HashSet<>();
	private String nome;
	private String img_perfil;

	public Usuario() {

	}

	public Usuario(Long id, String username, String password, Set<Role> roles, String nome, String img_perfil) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.nome = nome;
		this.img_perfil = img_perfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImg_perfil() {
		return img_perfil;
	}

	public void setImg_perfil(String img_perfil) {
		this.img_perfil = img_perfil;
	}

}