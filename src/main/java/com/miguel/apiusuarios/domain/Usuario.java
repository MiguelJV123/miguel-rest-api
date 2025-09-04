// Modelo que representa a un usuario
// @NotBlank, @Email, @Size, para verificacion de datos cuando llegan en JSON
package com.miguel.apiusuarios.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Usuario {

    private Long id;

    @NotBlank
    @Size(max = 80)
    private String nombre;

    @NotBlank
    @Email
    @Size(max = 120)
    private String email;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
