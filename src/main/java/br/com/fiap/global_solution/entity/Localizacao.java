package br.com.fiap.global_solution.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "localizacao")
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "localizacao_seq")
    @SequenceGenerator(name = "localizacao_seq", sequenceName = "SEQ_LOCALIZACAO", allocationSize = 1)
    @Column(name = "id_localizacao")
    private Long id;

    @Column(nullable = false, length = 100)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String estado;

    @Column(nullable = false, unique = true, length = 10)
    private String cep;

    @Column(nullable = false, length = 200)
    private String rua;

    @Column(nullable = false, length = 10)
    private String numero;

    @Column(length = 50)
    private String complemento;

    @OneToMany(mappedBy = "localizacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Abrigo> abrigos;

    public Localizacao() {}

    public Localizacao(Long id, String cidade, String estado, String cep, String rua, String numero, String complemento) {
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

    public List<Abrigo> getAbrigos() {
        return abrigos;
    }

    public void setAbrigos(List<Abrigo> abrigos) {
        this.abrigos = abrigos;
    }

}
