package com.magicbutton.magicbackend.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Datos que envia el formulario de Angular a la api
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCreateRequest {

    @NotBlank
    @Size(min=2,max = 120)
    private String nombre;

    @NotBlank
    @Size(max = 190)
    private String correo;

    @NotBlank
    @Size(min=6,max = 255)
    private String password;

    @NotBlank
    @Size(max = 30)
    private String rol;
}
