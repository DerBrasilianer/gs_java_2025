package br.com.fiap.global_solution.service;

import br.com.fiap.global_solution.dto.LocalizacaoCreateDTO;
import br.com.fiap.global_solution.dto.LocalizacaoDTO;
import br.com.fiap.global_solution.entity.Localizacao;
import br.com.fiap.global_solution.repository.LocalizacaoRepository;
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
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository repository;

    @PersistenceContext
    private EntityManager em;

    public List<LocalizacaoDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<LocalizacaoDTO> findById(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    @Transactional
    public LocalizacaoDTO create(LocalizacaoCreateDTO dto) {
        Long id = ((BigDecimal) em.createNativeQuery("SELECT SEQ_LOCALIZACAO.NEXTVAL FROM DUAL").getSingleResult()).longValue();

        em.createNativeQuery("CALL inserir_localizacao(?, ?, ?, ?, ?, ?, ?)")
                .setParameter(1, id)
                .setParameter(2, dto.getCidade())
                .setParameter(3, dto.getEstado())
                .setParameter(4, dto.getCep())
                .setParameter(5, dto.getRua())
                .setParameter(6, dto.getNumero())
                .setParameter(7, dto.getComplemento())
                .executeUpdate();

        return toDTO(new Localizacao(id, dto.getCidade(), dto.getEstado(), dto.getCep(), dto.getRua(), dto.getNumero(), dto.getComplemento()));
    }

    @Transactional
    public void update(Long id, LocalizacaoCreateDTO dto) {
        em.createNativeQuery("CALL atualizar_localizacao(?, ?, ?, ?, ?, ?, ?)")
                .setParameter(1, id)
                .setParameter(2, dto.getCidade())
                .setParameter(3, dto.getEstado())
                .setParameter(4, dto.getCep())
                .setParameter(5, dto.getRua())
                .setParameter(6, dto.getNumero())
                .setParameter(7, dto.getComplemento())
                .executeUpdate();
    }

    @Transactional
    public void delete(Long id) {
        em.createNativeQuery("CALL deletar_localizacao(?)")
                .setParameter(1, id)
                .executeUpdate();
    }

    private LocalizacaoDTO toDTO(Localizacao loc) {
        return new LocalizacaoDTO(loc.getId(), loc.getCidade(), loc.getEstado(), loc.getCep(), loc.getRua(), loc.getNumero(), loc.getComplemento());
    }

}
