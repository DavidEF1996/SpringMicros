package com.micro.usuario.usuarioservice.repository;

import com.micro.usuario.usuarioservice.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,String> {


}
