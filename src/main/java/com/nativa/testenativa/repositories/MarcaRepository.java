package com.nativa.testenativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nativa.testenativa.domain.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca ,Integer> {

	Marca findOne(Integer marcaid);

}
