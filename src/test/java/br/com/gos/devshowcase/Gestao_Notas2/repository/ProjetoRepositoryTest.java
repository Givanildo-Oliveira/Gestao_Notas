package br.com.gos.devshowcase.Gestao_Notas2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jpa.test.autoconfigure.AutoConfigureTestEntityManager;
import org.springframework.data.repository.CrudRepository;

import br.com.gos.devshowcase.Gestao_Notas2.model.Profile;
import br.com.gos.devshowcase.Gestao_Notas2.model.Projeto;

@org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest
class ProjectRepositoryTest {

    @Autowired
    private AutoConfigureTestEntityManager em;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Disabled
	@Test
    <S> void shouldPersistProjectWithProfile() {
        var profile = new Profile("Test User", "Tester", "http://a.com", "bio");
        ((Object) em).persist(profile);

        var projeto = new Projeto("Test Projeto", "Desc", "http://b.com", profile, null);
        CrudRepository<Projeto, Long> projectRepository;
		Object project;
		projectRepository.saveAll((S) project);
        
        var foundProjeto = ((Object) em).find(Projeto.class, projeto.getId());
        
        assertThat(foundProjeto).isNotNull();
        assertThat(((Projeto) foundProjeto).getProfile().getName()).isEqualTo("Test User");
    }
}
