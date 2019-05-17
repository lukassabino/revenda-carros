package br.com.lukas.atividades.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.lukas.atividades.domain.Revenda;
import br.com.lukas.atividades.enuns.EnumStatusCarro;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RevendaModel {

	// private List<CarroModel> carros;
	// private Long id;
	private String nome;
	private EnumStatusCarro status;
	private String carro;

	public RevendaModel(Revenda domain) {
		// this.carros =
		// domain.getCarros().stream().map(CarroModel::new).collect(Collectors.toList());
		this.nome = domain.getNome();
		this.status = domain.getStatus();
		this.carro = Objects.nonNull(domain.getCarro()) ? domain.getCarro().getNome() : "Sem carro";
	}
}
