package br.com.gos.devshowcase.service;

import java.util.List;

import br.com.gos.devshowcase.Gestao_Notas2.model.Tecnologia;

public interface TenologiaRepository {

	List<Tecnologia> findAll();

}
