package com.micro.usuario.usuarioservice.service.implementation;

import com.micro.usuario.usuarioservice.entity.Usuario;
import com.micro.usuario.usuarioservice.exceptions.ResourceNotFoundException;
import com.micro.usuario.usuarioservice.repository.UsuarioRepository;
import com.micro.usuario.usuarioservice.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveUser(Usuario usuario) {
        String userRamdom = UUID.randomUUID().toString();
        usuario.setUsuarioId(userRamdom);
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getUsers() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuario(String userId) {
        return usuarioRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Usuario no encontrado con el id: " + userId));
    }
}
