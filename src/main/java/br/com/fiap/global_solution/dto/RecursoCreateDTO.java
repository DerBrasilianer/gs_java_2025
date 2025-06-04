package br.com.fiap.global_solution.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class RecursoCreateDTO {

    @NotBlank
    @Schema(description = "Nome do recurso", example = "Cobertor térmico")
    private String nome;

    @NotBlank
    @Schema(description = "Tipo do recurso", example = "Material")
    private String tipo;

    @NotBlank
    @Schema(description = "Unidade de medida do recurso", example = "unidade")
    private String unidadeMedida;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

}
