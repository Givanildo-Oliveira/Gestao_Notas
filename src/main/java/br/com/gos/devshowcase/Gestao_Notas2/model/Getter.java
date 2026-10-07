package br.com.gos.devshowcase.Gestao_Notas2.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação para ser processada durante a compilação.
 * Marca uma classe para que um Annotation Processor gere os getters para seus campos.
 */
@Target(ElementType.TYPE) // Aplicável apenas em classes/interfaces/enums
@Retention(RetentionPolicy.SOURCE) // Disponível apenas durante a compilação
public @interface Getter {
}
