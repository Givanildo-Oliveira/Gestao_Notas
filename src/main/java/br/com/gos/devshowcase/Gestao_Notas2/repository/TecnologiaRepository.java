package br.com.gos.devshowcase.Gestao_Notas2.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gos.devshowcase.Gestao_Notas2.model.Profile;
import br.com.gos.devshowcase.Gestao_Notas2.model.Tecnologia;

@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia, Long>{

	Collection<? extends Tecnologia> findAll(Optional<Profile> technologyIds);

}
