package br.com.fiap.global_solution.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ocupante")
public class Ocupante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ocupante_seq")
    @SequenceGenerator(name = "ocupante_seq", sequenceName = "SEQ_OCUPANTE", allocationSize = 1)
    @Column(name = "id_ocupante")
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @Column(length = 20)
    private String genero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_abrigo", nullable = false)
    private Abrigo abrigo;

    public Ocupante() {}

    public Ocupante(Long id, String nome, Integer idade, String genero, Abrigo abrigo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.abrigo = abrigo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Abrigo getAbrigo() { return abrigo; }
    public void setAbrigo(Abrigo abrigo) { this.abrigo = abrigo; }

}
