package br.com.fiap.global_solution.controller;

import br.com.fiap.global_solution.dto.AbrigoCreateDTO;
import br.com.fiap.global_solution.dto.AbrigoDTO;
import br.com.fiap.global_solution.service.AbrigoService;
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
@RequestMapping("/api/abrigos")
@Tag(name = "Abrigo", description = "Endpoints para gerenciamento de abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoService service;

    @Operation(summary = "Lista todos os abrigos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<AbrigoDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Busca um abrigo pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Abrigo encontrado"),
            @ApiResponse(responseCode = "404", description = "Abrigo não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<AbrigoDTO> getById(
            @Parameter(description = "ID do abrigo", example = "1")
            @PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Cria um novo abrigo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Abrigo criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<AbrigoDTO> create(
            @Parameter(description = "Dados para criação do abrigo")
            @RequestBody @Valid AbrigoCreateDTO dto) {
        AbrigoDTO created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/abrigos/" + created.getId())).body(created);
    }

    @Operation(summary = "Atualiza um abrigo existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Abrigo atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Abrigo não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @Parameter(description = "ID do abrigo", example = "1")
            @PathVariable Long id,
            @Parameter(description = "Dados para atualização do abrigo")
            @RequestBody @Valid AbrigoCreateDTO dto) {
        service.update(id, dto);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Deleta um abrigo pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Abrigo deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Abrigo não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID do abrigo", example = "1")
            @PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
