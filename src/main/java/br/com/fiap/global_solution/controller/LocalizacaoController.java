package br.com.fiap.global_solution.controller;

import br.com.fiap.global_solution.dto.LocalizacaoCreateDTO;
import br.com.fiap.global_solution.dto.LocalizacaoDTO;
import br.com.fiap.global_solution.service.LocalizacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/localizacoes")
@Tag(name = "Localização", description = "Endpoints para gerenciamento de localizações")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService service;

    @Operation(summary = "Listar todas as localizações")
    @ApiResponse(responseCode = "200", description = "Lista de localizações retornada com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = LocalizacaoDTO.class)))
    @GetMapping
    public ResponseEntity<List<LocalizacaoDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Buscar localização por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Localização encontrada",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LocalizacaoDTO.class))),
            @ApiResponse(responseCode = "404", description = "Localização não encontrada", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<LocalizacaoDTO> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Criar nova localização")
    @ApiResponse(responseCode = "201", description = "Localização criada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = LocalizacaoDTO.class)))
    @PostMapping
    public ResponseEntity<LocalizacaoDTO> create(@RequestBody @Valid LocalizacaoCreateDTO dto) {
        LocalizacaoDTO created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/localizacoes/" + created.getId())).body(created);
    }

    @Operation(summary = "Atualizar localização existente")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Localização atualizada com sucesso", content = @Content),
            @ApiResponse(responseCode = "404", description = "Localização não encontrada", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid LocalizacaoCreateDTO dto) {
        service.update(id, dto);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Excluir localização")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Localização excluída com sucesso", content = @Content),
            @ApiResponse(responseCode = "404", description = "Localização não encontrada", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
