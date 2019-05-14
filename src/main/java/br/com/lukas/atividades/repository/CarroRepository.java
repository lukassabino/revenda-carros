package br.com.lukas.atividades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lukas.atividades.domain.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

}
