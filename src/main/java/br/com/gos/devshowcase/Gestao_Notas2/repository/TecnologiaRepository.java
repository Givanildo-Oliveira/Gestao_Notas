package br.com.gos.devshowcase.Gestao_Notas2.repository;

import org.springframework.data.repository.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gos.devshowcase.Gestao_Notas2.model.Tecnologia;

@Repository	
public interface TecnologiaRepository extends JpaRepository<Tenologia,long>{

}
