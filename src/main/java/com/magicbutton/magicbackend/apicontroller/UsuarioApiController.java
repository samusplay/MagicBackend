package com.magicbutton.magicbackend.apicontroller;

import com.magicbutton.magicbackend.api.UsuarioApi;
import com.magicbutton.magicbackend.models.UsuarioCreateRequest;
import com.magicbutton.magicbackend.models.UsuarioResponse;
import com.magicbutton.magicbackend.service.UsuarioService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UsuarioApiController implements UsuarioApi {
    private final UsuarioService usuarioService;

    @Override
    public ResponseEntity<UsuarioResponse> crear(UsuarioCreateRequest request) {
        UsuarioResponse resp=usuarioService.crearUsuario(request);

        URI location = URI.create("/usuarios/crear/" + resp.getId());
        return ResponseEntity.created(location).body(resp);
    }
}
