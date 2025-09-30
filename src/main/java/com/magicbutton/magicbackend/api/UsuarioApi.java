package com.magicbutton.magicbackend.api;

import com.magicbutton.magicbackend.models.UsuarioCreateRequest;
import com.magicbutton.magicbackend.models.UsuarioResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/usuarios")
public interface UsuarioApi {

    @PostMapping("/crear")
    ResponseEntity<UsuarioResponse>crear(
            @Valid
            @RequestBody
            UsuarioCreateRequest request
    );
}
