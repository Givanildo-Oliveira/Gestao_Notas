package br.com.gos.devshowcase.Gestao_Notas2.controller;

import br.com.gos.devshowcase.Gestao_Notas2.DTO.ProfileDTOs.*;
import br.com.gos.devshowcase.Gestao_Notas2.model.Profile;
import br.com.gos.devshowcase.Gestao_Notas2.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ProfileResponseDTO> create(@RequestBody @Valid ProfileCreateDTO dto, UriComponentsBuilder uriBuilder) {
        var profile = new Profile(dto.name(), dto.title(), dto.avatarUrl(), dto.bio());
        repository.save(profile);
        var uri = uriBuilder.path("/api/profiles/{id}").buildAndExpand(profile.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProfileResponseDTO(profile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponseDTO> getById(@PathVariable Long id) {
        var profile = repository.getReferenceById(id);
        return ResponseEntity.ok(new ProfileResponseDTO(profile));
    }
 // Adicione este método ao ProfileController
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProfileResponseDTO> update(@PathVariable Long id, @RequestBody @Valid ProfileUpdateDTO dto) {
        var profile = repository.getReferenceById(id);
        profile.updateInfo(dto);
        return ResponseEntity.ok(new ProfileResponseDTO(profile));
    }

 // Adicione este método ao ProfileController
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
