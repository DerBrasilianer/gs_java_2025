package br.com.fiap.global_solution.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class RecursoDTO {

    @Schema(description = "ID do recurso", example = "1")
    private Long id;

    @Schema(description = "Nome do recurso", example = "Cobertor térmico")
    private String nome;

    @Schema(description = "Tipo do recurso", example = "Material")
    private String tipo;

    @Schema(description = "Unidade de medida do recurso", example = "unidade")
    private String unidadeMedida;

    public RecursoDTO() {}

    public RecursoDTO(Long id, String nome, String tipo, String unidadeMedida) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.unidadeMedida = unidadeMedida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
