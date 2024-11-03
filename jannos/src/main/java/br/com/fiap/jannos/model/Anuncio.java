package br.com.fiap.jannos.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "t_goandgetit_anuncio")
public class Anuncio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull(message = "{anuncio.valor.validacao1}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{anuncio.valor.validacao2}")
    private Double valor;

	@NotNull(message = "{anuncio.quantidade.validacao1}")
	@Max(value = 9999, message = "{anuncio.quantidade.validacao2}")
    private Integer quantidade;

	@Size(max = 255, message = "{anuncio.descricao.validacao}")
    private String descricao;

	@NotNull(message = "{anuncio.prazo.validacao1}")
    @Size(max = 255, message = "{anuncio.prazo.validacao2}")
    private String prazo;

    @NotNull(message = "{anuncio.inico.validacao}")
    private Date inicio;

    private Date fim;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}
    
    

}
