package br.com.lukas.atividades.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.lukas.atividades.enuns.EnumStatusCarro;
import br.com.lukas.atividades.model.RevendaModel;
import lombok.Getter;

@Getter

@Entity
@Table(name = "revenda")
public class Revenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(targetEntity = Carro.class, cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<Carro> carros;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private EnumStatusCarro status;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(name = "carro_id")
	private Carro carro;

	@NotNull
	@Column(name = "nome", length = 128)
	private String nome;

	public Revenda() {
		this.carros = new ArrayList<>();
		this.status = EnumStatusCarro.NAO_VENDIDO;
	}

	public Revenda vender(Carro carro) {

		if (EnumStatusCarro.NAO_VENDIDO.equals(this.status)) {
			this.status = EnumStatusCarro.VENDIDO;
			this.carro = carro;
			return this;
		}
		throw new RuntimeException("Carro já vendido");

	}

	public Revenda(RevendaModel model) {
		this();
		this.nome = model.getNome();

	}

}
