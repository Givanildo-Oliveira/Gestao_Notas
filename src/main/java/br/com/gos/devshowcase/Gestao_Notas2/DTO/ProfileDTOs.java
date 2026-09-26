package br.com.gos.devshowcase.Gestao_Notas2.DTO;

import br.com.gos.devshowcase.Gestao_Notas2.model.Profile;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public final class ProfileDTOs {
    public record ProfileCreateDTO(
            @NotBlank String name,
            @NotBlank String title,
            @URL String avatarUrl,
            String bio
    ) {}

    public record ProfileResponseDTO(
            Long id,
            String name,
            String title,
            String avatarUrl,
            String bio
    ) {
        public ProfileResponseDTO(Profile profile) {
            this(profile.getId(), profile.getName(), profile.getName(), profile.getAvatarUrl(), profile.getId());
        }

		public ProfileResponseDTO(Long id2, String name2, String name3, String avatarUrl2, Long id3) {
			// TODO Auto-generated constructor stub
		}
    }
}
