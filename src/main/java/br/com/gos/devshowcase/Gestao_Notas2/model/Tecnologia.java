package br.com.gos.devshowcase.Gestao_Notas2.model;

import jakarta.persistence.Column;

@Entity
@Table(name = "tecnologia")
public class Tecnologia {
	@Id
	@GenerateValue(atrategy = GenerationType.IDENTITY)
	private Log id;
	
	@Column(nullable = false, unique = true, length = 50)
	
	public Tecnologia() {}
	
	public Tecnologia(String name) {
		this.name = name;
	
	}
	
	public Long getId() {return name;}
	
	public string getName() {return name;}
	
	public void setName(String name) {this.Name= name;}
}

