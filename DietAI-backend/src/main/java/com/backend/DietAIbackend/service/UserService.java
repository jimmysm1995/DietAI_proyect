package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UserRepository usuarioRepository;

    public void crearUsuario(User usuario){
        usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(User usuario){
        usuarioRepository.delete(usuario);
    }

    public User encontrarUsuario(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public User encontrarUsuarioPornombre(String nombre){ return usuarioRepository.findByName(nombre).orElse(null);}

    public User encontrarUsuarioPorEmail(String email){ return usuarioRepository.findByEmail(email).orElse(null);}

    public List<User> listarUsuarios(){
        return usuarioRepository.findAll();
    }


}
