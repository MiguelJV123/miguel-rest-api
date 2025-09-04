// Interfaz de la logica de negocio.
// Define Metodos CRUD
package com.miguel.apiusuarios.service;

import com.miguel.apiusuarios.domain.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> listar();

    Optional<Usuario> buscarPorId(Long id);

    Usuario crear(Usuario u);

    Usuario actualizar(Long id, Usuario u);

    void eliminar(Long id);
}
