package br.edu.up.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.up.hogwarts.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, Integer>{
}
