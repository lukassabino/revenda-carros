package br.com.lukas.atividades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lukas.atividades.domain.Revenda;
import br.com.lukas.atividades.enuns.EnumStatusCarro;

@Repository
public interface RevendaRepository extends JpaRepository<Revenda, Long> {

	List<Revenda> findByStatus(EnumStatusCarro status);

}
