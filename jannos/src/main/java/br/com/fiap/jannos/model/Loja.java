package br.com.fiap.jannos.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "t_goandgetit_loja")
public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "{loja.nome.validacao1}")
	@Size(min = 5, max = 255, message = "{loja.nome.validacao2}")
	private String nome;
	
	@NotNull(message = "{loja.tipo.validacao1}")
	@Size(min = 5, max = 255, message = "{loja.tipo.validacao2}")
	private String tipo;
	
	@Size(max = 255, message = "{loja.descricao.validacao}")
    private String descricao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	@Valid
	@NotNull(message = "{loja.endreco.validacao}")
	private Endereco endereco;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_nota")
	@Valid
	@NotNull(message = "{loja.nota.validacao}")
	private Nota nota;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}
	
	
	
	
}
