package br.com.gos.devshowcase.Gestao_Notas2.DTO;

import br.com.gos.devshowcase.Gestao_Notas2.model.Tecnologia;

public record TecnologiaResponse(Long id, String name) {
	
	public static TenologiaResponse fromEntity(Tecnologia tech) {
		return TecnologiaResponse (tech.getId(), tech.getName());
		
	}

}
