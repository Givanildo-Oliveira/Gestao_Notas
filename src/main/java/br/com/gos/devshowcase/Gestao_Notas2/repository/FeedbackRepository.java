package br.com.gos.devshowcase.Gestao_Notas2.repository;

import br.com.gos.devshowcase.Gestao_Notas2.model.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<FeedBack, Long> {}