package br.com.lukas.atividades.service;

import java.util.List;

import br.com.lukas.atividades.domain.Revenda;
import br.com.lukas.atividades.model.RevendaModel;

public interface RevendaService {

	Revenda cadastroRevenda(RevendaModel model);

	List<Revenda> minhaRevenda();

	Revenda vender(Long idCarro);

}