package br.com.gos.devshowcase.Gestao_Notas2.model;

@Getter
public class Pessoa {
    private String name;
    private int idade;

    public Pessoa(String name, int idade) {
        this.name = name;
        this.idade = idade;
    }
}
