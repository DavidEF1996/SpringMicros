package com.micro.usuario.usuarioservice.service;

import com.micro.usuario.usuarioservice.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario saveUser(Usuario usuario);

    List<Usuario> getUsers();

    Usuario getUsuario (String userId);


}
