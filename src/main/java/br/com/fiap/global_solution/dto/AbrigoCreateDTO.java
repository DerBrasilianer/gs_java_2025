package br.com.fiap.global_solution.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "DTO para criação ou atualização de Abrigo")
public class AbrigoCreateDTO {

    @NotBlank
    @Schema(description = "Nome do abrigo", example = "Abrigo Central", required = true)
    private String nome;

    @NotNull
    @Min(1)
    @Schema(description = "Capacidade do abrigo", example = "50", required = true)
    private Integer capacidade;

    @NotBlank
    @Pattern(regexp = "Ativo|Inativo|Esgotado")
    @Schema(description = "Status do abrigo (Ativo, Inativo, Esgotado)", example = "Ativo", required = true)
    private String status;

    @NotNull
    @Schema(description = "ID da localização associada", example = "2", required = true)
    private Long idLocalizacao;

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotNull @Min(1) Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(@NotNull @Min(1) Integer capacidade) {
        this.capacidade = capacidade;
    }

    public @NotBlank @Pattern(regexp = "Ativo|Inativo|Esgotado") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank @Pattern(regexp = "Ativo|Inativo|Esgotado") String status) {
        this.status = status;
    }

    public @NotNull Long getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(@NotNull Long idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

}
