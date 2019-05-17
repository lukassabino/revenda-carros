package br.com.lukas.atividades.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lukas.atividades.domain.Carro;
import br.com.lukas.atividades.domain.Revenda;
import br.com.lukas.atividades.enuns.EnumStatusCarro;
import br.com.lukas.atividades.model.RevendaModel;
import br.com.lukas.atividades.repository.RevendaRepository;
import br.com.lukas.atividades.service.CarroService;
import br.com.lukas.atividades.service.RevendaService;

@Transactional
@Service
public class RevendaServiceImpl implements RevendaService {

	@Autowired
	private RevendaRepository revendaRepository;

	@Autowired
	private CarroService carroService;

	@Override
	public Revenda cadastroRevenda(RevendaModel model) {

		return revendaRepository.save(new Revenda(model));
	}

	@Override
	public List<Revenda> minhaRevenda() {
		return revendaRepository.findAll();
	}

	private Revenda getRevenda() {
		List<Revenda> lista = revendaRepository.findByStatus(EnumStatusCarro.NAO_VENDIDO);
		if (lista.isEmpty()) {
			return this.revendaRepository.save(new Revenda());
		} else {
			return lista.get(0);
		}
	}

	@Override
	public Revenda vender(Long idCarro) {
		Optional<Carro> carro = carroService.consultar(idCarro);
		if (carro.isPresent()) {

			return this.revendaRepository.save(this.getRevenda().vender(carro.get()));
		}
		return null;
	}

}
