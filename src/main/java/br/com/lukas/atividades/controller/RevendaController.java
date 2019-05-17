package br.com.lukas.atividades.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lukas.atividades.model.RevendaModel;
import br.com.lukas.atividades.service.RevendaService;

@RestController
@RequestMapping("/revenda")
public class RevendaController {

	@Autowired
	private RevendaService revendaService;

	@PostMapping("/cadastrar-revenda")
	public RevendaModel cadastroRevenda(@RequestBody RevendaModel model) {
		return new RevendaModel(revendaService.cadastroRevenda(model));
	}

	@GetMapping("/minhas-revendas")
	public List<RevendaModel> minhaRevenda() {
		return revendaService.minhaRevenda().stream().map(RevendaModel::new).collect(Collectors.toList());
	}

	@PostMapping("/revendas")
	public RevendaModel vender(@RequestParam Long id) {
		return new RevendaModel(revendaService.vender(id));
	}

}
