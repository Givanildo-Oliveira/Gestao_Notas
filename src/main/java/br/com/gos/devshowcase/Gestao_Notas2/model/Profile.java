package br.com.gos.devshowcase.Gestao_Notas2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
}
