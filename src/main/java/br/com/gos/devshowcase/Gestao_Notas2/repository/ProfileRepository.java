package br.com.gos.devshowcase.Gestao_Notas2.repository;

import br.com.gos.devshowcase.Gestao_Notas2.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {}