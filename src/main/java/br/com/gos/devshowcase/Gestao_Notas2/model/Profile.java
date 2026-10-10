package br.com.gos.devshowcase.Gestao_Notas2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import br.com.gos.devshowcase.Gestao_Notas2.DTO.ProfileDTOs;

@Entity
@Table(name = "profiles")
@Getter
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String title;
    private String avatarUrl;
    private String bio;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Projeto> projetos = new ArrayList<>();

    public Profile(String name, String title, String avatarUrl, String bio) {
        this.name = name;
        this.title = title;
        this.avatarUrl = avatarUrl;
        this.bio = bio;
    }

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAvatarUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBio() {
		// TODO Auto-generated method stub
		return null;
	}
	// Adicione este método dentro da classe Profile
	public void updateInfo(ProfileDTOs.ProfileUpdateDTO dto) {
	    if (dto.name() != null && !dto.name().isBlank()) {
	        this.name = dto.name();
	    }
	    if (dto.title() != null && !dto.title().isBlank()) {
	        this.title = dto.title();
	    }
	    if (dto.avatarUrl() != null && !dto.avatarUrl().isBlank()) {
	        this.avatarUrl = dto.avatarUrl();
	    }
	    if (dto.bio() != null) {
	        this.bio = dto.bio();
	    }
	}

}
