package br.com.gos.devshowcase.Gestao_Notas2.DTO;

import jakarta.validation.constraints.NotBlank;

public class Record TecnologiaRequestDTO ( 
		@NotBlank (message = = " O nome da tecnologia é obrigatório")
		@Size (min = 2, max =50, message " O nome deve ter entre 2 e 50 caracteres")
		String name
		){}

