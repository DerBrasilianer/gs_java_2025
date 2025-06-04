package br.com.fiap.global_solution.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para transferência de dados de Abrigo")
public class AbrigoDTO {

    @Schema(description = "ID do abrigo", example = "1")
    private Long id;

    @Schema(description = "Nome do abrigo", example = "Abrigo Central")
    private String nome;

    @Schema(description = "Capacidade do abrigo", example = "50")
    private Integer capacidade;

    @Schema(description = "Status do abrigo", example = "Ativo")
    private String status;

    @Schema(description = "ID da localização associada", example = "2")
    private Long idLocalizacao;

    public AbrigoDTO() {}

    public AbrigoDTO(Long id, String nome, Integer capacidade, String status, Long idLocalizacao) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.status = status;
        this.idLocalizacao = idLocalizacao;
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

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(Long idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

}
