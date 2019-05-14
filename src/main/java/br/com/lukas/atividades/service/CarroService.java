package br.com.lukas.atividades.service;

import java.util.List;
import br.com.lukas.atividades.domain.Carro;
import br.com.lukas.atividades.model.CarroModel;

public interface CarroService {

	Carro cadastrarCarro(CarroModel model);

	List<Carro> estoque();

}