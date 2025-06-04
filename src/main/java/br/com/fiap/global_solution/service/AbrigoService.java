package br.com.fiap.global_solution.service;

import br.com.fiap.global_solution.dto.AbrigoCreateDTO;
import br.com.fiap.global_solution.dto.AbrigoDTO;
import br.com.fiap.global_solution.entity.Abrigo;
import br.com.fiap.global_solution.entity.Localizacao;
import br.com.fiap.global_solution.repository.AbrigoRepository;
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
public class AbrigoService {

    @Autowired
    private AbrigoRepository repository;

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    @PersistenceContext
    private EntityManager em;

    public List<AbrigoDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<AbrigoDTO> findById(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    @Transactional
    public AbrigoDTO create(AbrigoCreateDTO dto) {
        Long id = ((BigDecimal) em.createNativeQuery("SELECT SEQ_ABRIGO.NEXTVAL FROM DUAL").getSingleResult()).longValue();

        em.createNativeQuery("CALL inserir_abrigo(?, ?, ?, ?, ?)")
                .setParameter(1, id)
                .setParameter(2, dto.getNome())
                .setParameter(3, dto.getCapacidade())
                .setParameter(4, dto.getStatus())
                .setParameter(5, dto.getIdLocalizacao())
                .executeUpdate();

        Localizacao localizacao = localizacaoRepository.findById(dto.getIdLocalizacao()).orElse(null);
        return toDTO(new Abrigo(id, dto.getNome(), dto.getCapacidade(), dto.getStatus(), localizacao));
    }

    @Transactional
    public void update(Long id, AbrigoCreateDTO dto) {
        em.createNativeQuery("CALL atualizar_abrigo(?, ?, ?, ?, ?)")
                .setParameter(1, id)
                .setParameter(2, dto.getNome())
                .setParameter(3, dto.getCapacidade())
                .setParameter(4, dto.getStatus())
                .setParameter(5, dto.getIdLocalizacao())
                .executeUpdate();
    }

    @Transactional
    public void delete(Long id) {
        em.createNativeQuery("CALL deletar_abrigo(?)")
                .setParameter(1, id)
                .executeUpdate();
    }

    private AbrigoDTO toDTO(Abrigo abrigo) {
        return new AbrigoDTO(
                abrigo.getId(),
                abrigo.getNome(),
                abrigo.getCapacidade(),
                abrigo.getStatus(),
                abrigo.getLocalizacao() != null ? abrigo.getLocalizacao().getId() : null
        );
    }

}
