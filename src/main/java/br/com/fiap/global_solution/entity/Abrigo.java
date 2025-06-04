package br.com.fiap.global_solution.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "abrigo")
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "abrigo_seq")
    @SequenceGenerator(name = "abrigo_seq", sequenceName = "SEQ_ABRIGO", allocationSize = 1)
    @Column(name = "id_abrigo")
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private Integer capacidade;

    @Column(length = 20)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_localizacao", nullable = false)
    private Localizacao localizacao;

    @OneToMany(mappedBy = "abrigo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ocupante> ocupantes;

    public Abrigo() {}

    public Abrigo(Long id, String nome, Integer capacidade, String status, Localizacao localizacao) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.status = status;
        this.localizacao = localizacao;
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

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public List<Ocupante> getOcupantes() {
        return ocupantes;
    }

    public void setOcupantes(List<Ocupante> ocupantes) {
        this.ocupantes = ocupantes;
    }

}
