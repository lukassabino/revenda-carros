package br.com.lukas.atividades.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.lukas.atividades.model.CarroModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

@Entity
@Table(name = "carro")
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "nome", length = 128)
	private String nome;

	@NotNull
	@Column(name = "cor", length = 128)
	private String cor;

	@NotNull
	@Column(name = "ano", length = 128)
	private Integer ano;

	@NotNull
	@Column(name = "completo", length = 128)
	private Boolean completo;

	public Carro(CarroModel model) {
		this();
		this.nome = model.getNome();
		this.cor = model.getCor();
		this.ano = model.getAno();
		this.completo = model.getCompleto();
	}

}
