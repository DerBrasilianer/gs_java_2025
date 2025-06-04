package br.com.fiap.global_solution.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class OcupanteDTO {

    @Schema(description = "ID do ocupante", example = "1")
    private Long id;

    @Schema(description = "Nome completo do ocupante", example = "Maria Silva")
    private String nome;

    @Schema(description = "Idade do ocupante", example = "30")
    private Integer idade;

    @Schema(description = "Gênero do ocupante", example = "Feminino")
    private String genero;

    @Schema(description = "ID do abrigo associado", example = "1")
    private Long idAbrigo;

    // Construtores, getters e setters (sem alterações)
    public OcupanteDTO() {}

    public OcupanteDTO(Long id, String nome, Integer idade, String genero, Long idAbrigo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.idAbrigo = idAbrigo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public Long getIdAbrigo() { return idAbrigo; }
    public void setIdAbrigo(Long idAbrigo) { this.idAbrigo = idAbrigo; }

}
