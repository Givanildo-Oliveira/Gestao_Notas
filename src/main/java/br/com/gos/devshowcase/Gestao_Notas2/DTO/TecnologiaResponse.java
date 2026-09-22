package br.com.gos.devshowcase.Gestao_Notas2.DTO;

import br.com.gos.devshowcase.Gestao_Notas2.model.Tecnologia;

public record TecnologiaResponse(Long id, String name) {
	
	public static TecnologiaResponse fromEntity(Tecnologia tech) {
		return new TecnologiaResponse(tech.getId(), tech.getName());
		
	}

}
