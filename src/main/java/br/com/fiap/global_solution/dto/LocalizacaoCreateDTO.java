package br.com.fiap.global_solution.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "DTO para criação e atualização da Localização")
public class LocalizacaoCreateDTO {

    @NotBlank
    @Schema(description = "Nome da cidade", example = "São Paulo", required = true)
    private String cidade;

    @NotBlank
    @Size(min = 2, max = 2)
    @Schema(description = "Sigla do estado (2 caracteres)", example = "SP", required = true)
    private String estado;

    @NotBlank
    @Schema(description = "CEP da localização", example = "01234-567", required = true)
    private String cep;

    @NotBlank
    @Schema(description = "Nome da rua", example = "Rua das Flores", required = true)
    private String rua;

    @NotBlank
    @Schema(description = "Número do endereço", example = "123", required = true)
    private String numero;

    @Schema(description = "Complemento do endereço", example = "Apartamento 45")
    private String complemento;

    public @NotBlank String getCidade() {
        return cidade;
    }

    public void setCidade(@NotBlank String cidade) {
        this.cidade = cidade;
    }

    public @NotBlank @Size(min = 2, max = 2) String getEstado() {
        return estado;
    }

    public void setEstado(@NotBlank @Size(min = 2, max = 2) String estado) {
        this.estado = estado;
    }

    public @NotBlank String getCep() {
        return cep;
    }

    public void setCep(@NotBlank String cep) {
        this.cep = cep;
    }

    public @NotBlank String getRua() {
        return rua;
    }

    public void setRua(@NotBlank String rua) {
        this.rua = rua;
    }

    public @NotBlank String getNumero() {
        return numero;
    }

    public void setNumero(@NotBlank String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

}
