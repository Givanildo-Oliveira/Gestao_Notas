package br.com.gos.devshowcase.Gestao_Notas2.service;

import br.com.gos.devshowcase.Gestao_Notas2.model.Projeto;
import br.com.gos.devshowcase.Gestao_Notas2.model.Tecnologia;
import br.com.gos.devshowcase.Gestao_Notas2.repository.ProfileRepository;

import br.com.gos.devshowcase.Gestao_Notas2.repository.ProjetoRepository;
import br.com.gos.devshowcase.Gestao_Notas2.repository.TecnologiaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    @SuppressWarnings("unused")
	public Projeto createProject(br.com.gos.devshowcase.Gestao_Notas2.DTO.ProjetoDTOs.@Valid ProjectCreateDTO dto) {
        var profile = profileRepository.findById(dto.profileId())
                .orElseThrow(() -> new EntityNotFoundException("Profile com ID " + dto.profileId() + " não encontrado."));

        Set<Tecnologia> tecnologias = new HashSet<>();
        if (dto.technologyIds() != null && !dto.technologyIds().isEmpty()) {
            boolean all = tecnologias.addAll(tecnologiaRepository.findAll(dto.technologyIds()));
        }

        var projeto = new Projeto(dto.title(), dto.description(), dto.repoUrl(), profile, tecnologias);
        return projetoRepository.save(projeto);
    }
}
