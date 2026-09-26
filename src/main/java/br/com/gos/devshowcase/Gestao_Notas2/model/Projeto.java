package br.com.gos.devshowcase.Gestao_Notas2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "projetos")
@Getter
@Setter
@NoArgsConstructor
public class Projeto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String repoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @ManyToMany
    @JoinTable(
            name = "projeto_tecnologia",
            joinColumns = @JoinColumn(name = "projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnologia_id")
    )
    private Set<Tecnologia> technologias = new HashSet<>();

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FeedBack> feedbacks = new ArrayList<>();

    public Projeto(String title, String description, String repoUrl, Profile profile, Set<Tecnologia> tecnologias) {
        this.title = title;
        this.description = description;
        this.repoUrl = repoUrl;
        this.profile = profile;
        this.tecnologias = tecnologias;
    }

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
}

