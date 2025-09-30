package com.magicbutton.magicbackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lo que responde la apial crear
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
    private Long id;
    private String nombre;
    private String correo;
    private String rol;
    private LocalDateTime creadoEn;
}
