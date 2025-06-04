package br.com.fiap.global_solution.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recurso")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recurso_seq")
    @SequenceGenerator(name = "recurso_seq", sequenceName = "SEQ_RECURSO", allocationSize = 1)
    @Column(name = "id_recurso")
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(name = "unidade_medida", nullable = false, length = 20)
    private String unidadeMedida;

    public Recurso() {}

    public Recurso(Long id, String nome, String tipo, String unidadeMedida) {
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
