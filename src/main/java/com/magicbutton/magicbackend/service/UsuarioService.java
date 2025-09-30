package com.magicbutton.magicbackend.service;

import com.magicbutton.magicbackend.models.UsuarioCreateRequest;
import com.magicbutton.magicbackend.models.UsuarioResponse;

import java.util.List;

public interface UsuarioService {
    //Firma de la funcionalidad
    UsuarioResponse crearUsuario(UsuarioCreateRequest request);
    List<UsuarioResponse>listarUsuarios();

}
