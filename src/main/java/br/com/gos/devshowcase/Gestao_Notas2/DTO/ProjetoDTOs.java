// ProjectDTOs.java
package br.com.gos.devshowcase.Gestao_Notas2.DTO;

import br.com.gos.devshowcase.Gestao_Notas2.model.Projeto;
import br.com.gos.devshowcase.Gestao_Notas2.model.Tecnologia;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;
import java.util.Set;
import java.util.stream.Collectors;

public final class ProjetoDTOs {
    public record ProjectCreateDTO(
            @NotBlank String title,
            @NotBlank String description,
            @URL String repoUrl,
            @NotNull Long profileId,
            Set<Long> tecnologiaIds
    ) {}

    public record ProjectResponseDTO(
            Long id,
            String title,
            String description,
            String repoUrl,
            Long profileId,
            Set<Tecnologia.TecnologiaResponse> tecnologias
    ) {
        public ProjectResponseDTO(Projeto projeto) {
            this(
                    projeto.getId(),
                    projeto.getTitle(),
                    projeto.getDescription(),
                    projeto.getRepoUrl(),
                    projeto.getProfile().getId(),
                    projeto.getTecnologias().stream()
                            .map(Tecnologia.TecnologiaResponse::new)
                            .collect(Collectors.toSet())
            );
        }
    }
}
