package br.com.gos.devshowcase.Gestao_Notas2.controller;

import br.com.gos.devshowcase.Gestao_Notas2.DTO.ProjetoDTOs.*;
import br.com.gos.devshowcase.Gestao_Notas2.model.Projeto;
import br.com.gos.devshowcase.Gestao_Notas2.repository.ProjetoRepository;
import br.com.gos.devshowcase.Gestao_Notas2.service.ProjetoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjetoService service;
    
    @Autowired
    private ProjetoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ProjectResponseDTO> create(@RequestBody @Valid ProjectCreateDTO dto, UriComponentsBuilder uriBuilder) {
        var projeto = service.createProject(dto);
        URI uri = uriBuilder.path("/api/projetos/{id}").buildAndExpand(((Projeto) projeto).getId()).toUri();
        return ResponseEntity.created(uri).body(new ProjectResponseDTO(projeto));
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> list() {
        var projects = repository.findAll().stream()
                .map(ProjectResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(projects);
    }
}
