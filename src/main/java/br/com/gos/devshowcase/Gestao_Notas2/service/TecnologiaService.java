package br.com.gos.devshowcase.Gestao_Notas2.service;

import br.com.gos.devshowcase.Gestao_Notas2.DTO.TecnologiaResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gos.devshowcase.Gestao_Notas2.repository.TecnologiaRepository;
import java.util.List;

@Service
public class TecnologiaService {

	@Autowired
	private TecnologiaRepository repository;
	
	@Transactional
	public List <TecnologiaResponse> buscarTodos(){
		return repository.findAll().stream()
				.map(TecnologiaResponse::fromEntity)
				.toList();
	}

}
