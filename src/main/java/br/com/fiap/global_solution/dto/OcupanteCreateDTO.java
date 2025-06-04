package br.com.fiap.global_solution.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

public class OcupanteCreateDTO {

    @Schema(description = "Nome completo do ocupante", example = "Maria Silva", required = true)
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Schema(description = "Idade do ocupante", example = "30", required = true)
    @NotNull(message = "Idade é obrigatória")
    @Min(value = 0, message = "Idade mínima é 0")
    private Integer idade;

    @Schema(description = "Gênero do ocupante", example = "Feminino")
    private String genero;

    @Schema(description = "ID do abrigo associado", example = "1", required = true)
    @NotNull(message = "ID do abrigo é obrigatório")
    private Long idAbrigo;

    // getters e setters (sem alterações)
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public Long getIdAbrigo() { return idAbrigo; }
    public void setIdAbrigo(Long idAbrigo) { this.idAbrigo = idAbrigo; }

}
