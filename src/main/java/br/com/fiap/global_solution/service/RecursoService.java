package br.com.fiap.global_solution.service;

import br.com.fiap.global_solution.dto.RecursoCreateDTO;
import br.com.fiap.global_solution.dto.RecursoDTO;
import br.com.fiap.global_solution.entity.Recurso;
import br.com.fiap.global_solution.repository.RecursoRepository;
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
public class RecursoService {

    @Autowired
    private RecursoRepository repository;

    @PersistenceContext
    private EntityManager em;

    public List<RecursoDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<RecursoDTO> findById(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    @Transactional
    public RecursoDTO create(RecursoCreateDTO dto) {
        Long id = ((BigDecimal) em.createNativeQuery("SELECT SEQ_RECURSO.NEXTVAL FROM DUAL").getSingleResult()).longValue();

        em.createNativeQuery("CALL inserir_recurso(?, ?, ?, ?)")
                .setParameter(1, id)
                .setParameter(2, dto.getNome())
                .setParameter(3, dto.getTipo())
                .setParameter(4, dto.getUnidadeMedida())
                .executeUpdate();

        return toDTO(new Recurso(id, dto.getNome(), dto.getTipo(), dto.getUnidadeMedida()));
    }

    @Transactional
    public void update(Long id, RecursoCreateDTO dto) {
        em.createNativeQuery("CALL atualizar_recurso(?, ?, ?, ?)")
                .setParameter(1, id)
                .setParameter(2, dto.getNome())
                .setParameter(3, dto.getTipo())
                .setParameter(4, dto.getUnidadeMedida())
                .executeUpdate();
    }

    @Transactional
    public void delete(Long id) {
        em.createNativeQuery("CALL deletar_recurso(?)")
                .setParameter(1, id)
                .executeUpdate();
    }

    private RecursoDTO toDTO(Recurso recurso) {
        return new RecursoDTO(recurso.getId(), recurso.getNome(), recurso.getTipo(), recurso.getUnidadeMedida());
    }

}
