package br.com.lukas.atividades.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.lukas.atividades.model.CarroModel;
import br.com.lukas.atividades.service.CarroService;

@RestController
@RequestMapping("/revenda")
public class CarroController {

	@Autowired
	private CarroService carroService;

	@PostMapping("/cadastrar-carro")
	public CarroModel cadastrarCarro(@RequestBody CarroModel model) {
		return new CarroModel(carroService.cadastrarCarro(model));
	}

	@GetMapping("/estoque")
	public List<CarroModel> estoque() {
		return carroService.estoque().stream().map(CarroModel::new).collect(Collectors.toList());
	}

}
