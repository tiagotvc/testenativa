package com.nativa.testenativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nativa.testenativa.domain.Marca;
import com.nativa.testenativa.domain.Patrimonio;

@Repository
public interface PatrimonioRepository extends JpaRepository<Patrimonio ,Integer> {

	

}
