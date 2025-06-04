package br.com.fiap.global_solution.service;

import br.com.fiap.global_solution.dto.OcupanteCreateDTO;
import br.com.fiap.global_solution.dto.OcupanteDTO;
import br.com.fiap.global_solution.entity.Abrigo;
import br.com.fiap.global_solution.entity.Ocupante;
import br.com.fiap.global_solution.repository.AbrigoRepository;
import br.com.fiap.global_solution.repository.OcupanteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OcupanteService {

    @Autowired
    private OcupanteRepository repository;

    @Autowired
    private AbrigoRepository abrigoRepository;

    @PersistenceContext
    private EntityManager em;

    public List<OcupanteDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<OcupanteDTO> findById(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    @Transactional
    public OcupanteDTO create(OcupanteCreateDTO dto) {
        Long id = ((BigDecimal) em.createNativeQuery("SELECT SEQ_OCUPANTE.NEXTVAL FROM DUAL").getSingleResult()).longValue();

        em.createNativeQuery("CALL inserir_ocupante(?, ?, ?, ?, ?)")
                .setParameter(1, id)
                .setParameter(2, dto.getNome())
                .setParameter(3, dto.getIdade())
                .setParameter(4, dto.getGenero())
                .setParameter(5, dto.getIdAbrigo())
                .executeUpdate();

        Abrigo abrigo = abrigoRepository.findById(dto.getIdAbrigo())
                .orElseThrow(() -> new IllegalArgumentException("Abrigo não encontrado"));

        return toDTO(new Ocupante(id, dto.getNome(), dto.getIdade(), dto.getGenero(), abrigo));
    }

    @Transactional
    public void update(Long id, OcupanteCreateDTO dto) {
        em.createNativeQuery("CALL atualizar_ocupante(?, ?, ?, ?, ?)")
                .setParameter(1, id)
                .setParameter(2, dto.getNome())
                .setParameter(3, dto.getIdade())
                .setParameter(4, dto.getGenero())
                .setParameter(5, dto.getIdAbrigo())
                .executeUpdate();
    }

    @Transactional
    public void delete(Long id) {
        em.createNativeQuery("CALL deletar_ocupante(?)")
                .setParameter(1, id)
                .executeUpdate();
    }

    private OcupanteDTO toDTO(Ocupante o) {
        return new OcupanteDTO(o.getId(), o.getNome(), o.getIdade(), o.getGenero(), o.getAbrigo().getId());
    }

}
