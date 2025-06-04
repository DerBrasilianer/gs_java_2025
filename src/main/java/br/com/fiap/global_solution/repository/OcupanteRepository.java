package br.com.fiap.global_solution.repository;

import br.com.fiap.global_solution.entity.Ocupante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcupanteRepository extends JpaRepository<Ocupante, Long> {}
