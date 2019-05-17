package br.com.lukas.atividades.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.lukas.atividades.model.CarroModel;
import br.com.lukas.atividades.service.CarroService;

@RestController
@RequestMapping("/veiculo")
public class CarroController {

	@Autowired
	private CarroService carroService;

	@PostMapping("/cadastrar-carro")
	public CarroModel cadastrarCarro(@Valid @RequestBody CarroModel model, BindingResult bindingResult) {

		if (!bindingResult.hasErrors()) {
			return new CarroModel(carroService.cadastrarCarro(model));
		}
		throw new RuntimeException("Model invalida");

	}

	@GetMapping("/estoque")
	public List<CarroModel> estoque() {
		return carroService.estoque().stream().map(CarroModel::new).collect(Collectors.toList());
	}

}
