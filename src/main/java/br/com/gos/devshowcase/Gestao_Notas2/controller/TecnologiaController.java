package br.com.gos.devshowcase.Gestao_Notas2.controller;

import br.com.gos.devshowcase.Gestao_Notas2.DTO.TecnologiaResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gos.devshowcase.Gestao_Notas2.service.TecnologiaService;

@RestController @RequestMapping("/api/tecnologias")
public class TecnologiaController {
	
	@Autowired
	private TecnologiaService service;
	
	@GetMapping 
	public ResponseEntity <List<TecnologiaResponse>> findAll(){
		return ResponseEntity.ok (service.buscarTodos());
	}

}
