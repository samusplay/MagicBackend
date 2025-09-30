package com.magicbutton.magicbackend.service.impl;

import com.magicbutton.magicbackend.entity.Usuario;
import com.magicbutton.magicbackend.models.UsuarioCreateRequest;
import com.magicbutton.magicbackend.models.UsuarioResponse;
import com.magicbutton.magicbackend.repository.UsuarioRepository;
import com.magicbutton.magicbackend.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    @Override
    public UsuarioResponse crearUsuario(UsuarioCreateRequest request) {
        //Validar duplicado
        if(usuarioRepository.existsByCorreo(request.getCorreo())){
            throw  new DataIntegrityViolationException("El correo ya esta registrado");
        }
        //Mapear el Dto para la base de datos
        Usuario nuevo=new Usuario();
        nuevo.setName(request.getNombre());
        nuevo.setCorreo(request.getCorreo());

        //luego incriptar
        nuevo.setPassword(request.getPassword());
        nuevo.setRol(request.getRol());

        Usuario saved =usuarioRepository.save(nuevo);

        //Devolvemos el Objeto en el Response
        return new UsuarioResponse(
                saved.getId(),
                saved.getName(),
                saved.getCorreo(),
                saved.getRol(),
                saved.getCreadoEn()
        );

    }

    @Override
    public List<UsuarioResponse> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(u ->new UsuarioResponse(
                u.getId(),u.getName(),u.getCorreo(),u.getRol(),u.getCreadoEn()
        ))
                .toList();
    }
}
