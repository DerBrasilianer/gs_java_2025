package br.com.fiap.global_solution.controller;

import br.com.fiap.global_solution.dto.OcupanteCreateDTO;
import br.com.fiap.global_solution.dto.OcupanteDTO;
import br.com.fiap.global_solution.service.OcupanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ocupantes")
@Tag(name = "Ocupantes", description = "Endpoints para gerenciamento de ocupantes")
public class OcupanteController {

    @Autowired
    private OcupanteService service;

    @Operation(summary = "Listar todos os ocupantes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de ocupantes retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<OcupanteDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Buscar ocupante pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ocupante encontrado"),
            @ApiResponse(responseCode = "404", description = "Ocupante não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<OcupanteDTO> getById(
            @Parameter(description = "ID do ocupante", example = "1")
            @PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Criar um novo ocupante")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Ocupante criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos na requisição")
    })
    @PostMapping
    public ResponseEntity<OcupanteDTO> create(
            @Parameter(description = "Dados para criação do ocupante")
            @RequestBody @Valid OcupanteCreateDTO dto) {
        OcupanteDTO created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/ocupantes/" + created.getId())).body(created);
    }

    @Operation(summary = "Atualizar ocupante existente")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Ocupante atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos na requisição"),
            @ApiResponse(responseCode = "404", description = "Ocupante não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @Parameter(description = "ID do ocupante para atualizar", example = "1")
            @PathVariable Long id,
            @Parameter(description = "Dados para atualização do ocupante")
            @RequestBody @Valid OcupanteCreateDTO dto) {
        service.update(id, dto);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Deletar ocupante pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Ocupante deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ocupante não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID do ocupante para deletar", example = "1")
            @PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
