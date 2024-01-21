package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Usuario;
import com.backend.DietAIbackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void crearUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Usuario usuario){
        usuarioRepository.delete(usuario);
    }

    public Usuario encontrarUsuario(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }


}
