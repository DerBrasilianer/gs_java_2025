package br.com.fiap.global_solution.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para visualizar informações da Localização")
public class LocalizacaoDTO {

    @Schema(description = "Identificador da localização", example = "1")
    private Long id;

    @Schema(description = "Nome da cidade", example = "São Paulo")
    private String cidade;

    @Schema(description = "Sigla do estado (2 caracteres)", example = "SP")
    private String estado;

    @Schema(description = "CEP da localização", example = "01234-567")
    private String cep;

    @Schema(description = "Nome da rua", example = "Rua das Flores")
    private String rua;

    @Schema(description = "Número do endereço", example = "123")
    private String numero;

    @Schema(description = "Complemento do endereço", example = "Apartamento 45")
    private String complemento;

    public LocalizacaoDTO() {}

    public LocalizacaoDTO(Long id, String cidade, String estado, String cep, String rua, String numero, String complemento) {
        this.id = id;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

}
