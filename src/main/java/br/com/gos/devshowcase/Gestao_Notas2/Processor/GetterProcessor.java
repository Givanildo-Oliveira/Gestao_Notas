package br.com.gos.devshowcase.Gestao_Notas2.processor;

import br.com.gos.devshowcase.Gestao_Notas2.model.Getter;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

// Registra o processador para a anotação e versão do Java
@SupportedAnnotationTypes("br.com.gos.devshowcase.Gestao_Notas2.model.Getter")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class GetterProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // Itera sobre todas as classes anotadas com @Getter
        for (Element element : roundEnv.getElementsAnnotatedWith(Getter.class)) {
            if (element.getKind() == ElementKind.CLASS) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Processando classe: " + element.getSimpleName());

                // Itera sobre os campos da classe
                for (Element enclosedElement : element.getEnclosedElements()) {
                    if (enclosedElement.getKind() == ElementKind.FIELD) {
                        String fieldName = enclosedElement.getSimpleName().toString();
                        String fieldType = enclosedElement.asType().toString();
                        String getterName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);

                        // Gera a representação do método getter como uma String
                        String getterCode = String.format(
                            "    public %s %s() {\n        return this.%s;\n    }\n",
                            fieldType, getterName, fieldName
                        );

                        // Imprime o "código gerado" como uma nota no console de compilação
                        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Getter gerado para o campo '" + fieldName + "':\n" + getterCode);
                    }
                }
            }
        }
        // Retorna 'false' para permitir que outros processadores também atuem sobre estas anotações, se houver.
        return false;
    }
}
