package br.com.lukas.atividades.model;

import br.com.lukas.atividades.domain.Carro;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CarroModel {

	private Long id;
	private String nome;
	private String cor;
	private Integer ano;
	private Boolean completo;

	public CarroModel(Carro domain) {
		this.id = domain.getId();
		this.nome = domain.getNome();
		this.cor = domain.getCor();
		this.ano = domain.getAno();
		this.completo = domain.getCompleto();

	}
}
