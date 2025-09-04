package com.miguel.apiusuarios.service.impl;

import com.miguel.apiusuarios.domain.Usuario;
import com.miguel.apiusuarios.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    // Usa un ConcurrentHashMap<Long, Usuario> como “base de datos” temporal.
    private final Map<Long, Usuario> store = new ConcurrentHashMap<>();
    // Genera IDs
    private final AtomicLong idGen = new AtomicLong(1);

    @Override
    public List<Usuario> listar() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Usuario crear(Usuario u) {
        long id = idGen.getAndIncrement();
        u.setId(id);
        store.put(id, u);
        return u;
    }

    @Override
    public Usuario actualizar(Long id, Usuario u) {
        Usuario actual = store.get(id);
        // Si no encuentra el usuario (la maneja el handler global).
        if (actual == null) {
            throw new NoSuchElementException("Usuario no encontrado");
        }
        actual.setNombre(u.getNombre());
        actual.setEmail(u.getEmail());
        return actual;
    }

    @Override
    public void eliminar(Long id) {
        store.remove(id);
    }
}
