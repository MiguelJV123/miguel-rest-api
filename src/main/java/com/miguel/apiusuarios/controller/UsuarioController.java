// Expone la API REST
package com.miguel.apiusuarios.controller;

import com.miguel.apiusuarios.domain.Usuario;
import com.miguel.apiusuarios.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // Lista todos
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    // Trae uno
    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable("id") Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));
    }

    // Crea (requiere JSON válido)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario crear(@Valid @RequestBody Usuario u) {
        return service.crear(u);
    }

    // Actualiza
    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable("id") Long id,
            @Valid @RequestBody Usuario u) {
        return service.actualizar(id, u);
    }

    // Elimina
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable("id") Long id) {
        service.eliminar(id);
    }
}
