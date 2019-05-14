package br.com.lukas.atividades.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.lukas.atividades.domain.Carro;
import br.com.lukas.atividades.model.CarroModel;
import br.com.lukas.atividades.repository.CarroRepository;
import br.com.lukas.atividades.service.CarroService;

@Transactional
@Service
public class CarroServiceImpl implements CarroService {

	@Autowired
	private CarroRepository carroRepository;

	@Override
	public Carro cadastrarCarro(CarroModel model) {

		return carroRepository.save(new Carro(model));
	}

	@Override
	public List<Carro> estoque() {
		return carroRepository.findAll();
	}

}
