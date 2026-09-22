package br.com.gos.devshowcase.Gestao_Notas2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gos.devshowcase.service.TenologiaRepository;
import java.util.List;

@Service
public class TecnologiaService {
	
	@Autowired
	private TenologiaRepository repository;
	
	@Transational(readOnly = true)
	public List <TecnologiaResponse> buscarTodos(){
		return repository.findAll().stream()
				.map(TecnologiaResponse::fromEntity)
				.toList();
	}

}
