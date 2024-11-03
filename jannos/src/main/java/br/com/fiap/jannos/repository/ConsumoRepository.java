package br.com.fiap.jannos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.jannos.model.Consumo;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long> {

}
