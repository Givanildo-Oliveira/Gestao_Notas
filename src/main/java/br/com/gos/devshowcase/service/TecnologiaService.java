package br.com.gos.devshowcase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gos.devshowcase.Gestao_Notas2.model.Tecnologia;
import br.com.gos.devshowcase.Repository.TecnologiaRrepository;
import jakarta.transaction.Transactional;

@Service 
public class TecnologiaService {
	
	@Autowired 
	private TenologiaRepository repository;
	
	@Transactional(readOnly = true)
	public List<Tecnologia> busarTodos() {
		return repository.findAll();
	}

}
