package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.model.UserAuthority;
import com.backend.DietAIbackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    /**
     * Devuelve todos los usuarios
     *
     * @return
     */
    public List<User> findAll() {
        if (userRepository.findAll().isEmpty()){
            throw new ServiceException("No se han encontrado usuarios", HttpStatus.NOT_FOUND);
        }
        return userRepository.findAll();
    }

    /**
     * Encuentra un usuario por su id
     * @param id
     * @return
     */
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ServiceException("No se ha encontrado el usuario", HttpStatus.NOT_FOUND));
    }

    /**
     * Registra al usuario
     *
     * @param user
     * @param isAdmin
     * @return
     */
    @Override
    public User register(User user, boolean isAdmin) {

        // Verificar si el nombre de usuario o el correo electrónico ya existen
        Optional<User> existingUser = userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail());
        if (existingUser.isPresent()) {
            throw new ServiceException("El nombre de usuario o correo electrónico ya están en uso", HttpStatus.CONFLICT);
        }

        // Hashear la contraseña antes de almacenarla
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Crear un nuevo usuario y guardarlo en la base de datos
        User registerUser = new User(user.getUsername(), user.getEmail(), user.getPassword(), isAdmin);
        return userRepository.save(registerUser);
    }

    /**
     * Actualiza al usuario
     *
     * @param user
     * @return
     */
    public User update(User user) {
        // Verificar que el usuario existe
        Optional<User> existingUserOptional = userRepository.findById(user.getIdUser());
        if (!existingUserOptional.isPresent()) {
            throw new ServiceException("No existe el Usuario en cuestión", HttpStatus.NOT_FOUND);
        }

        // Verificar que el nombre de usuario no esté en conflicto con otro usuario existente
        List<User> userList = userRepository.findAll();
        for (User existingUser : userList) {
            if (existingUser.getUsername().equals(user.getUsername()) && !existingUser.getIdUser().equals(user.getIdUser())) {
                throw new ServiceException("Ya existe un usuario con ese nombre", HttpStatus.CONFLICT);
            }
        }

        // Guardar y retornar el usuario actualizado
        return userRepository.save(user);
    }


    /**
     * Elimina al usuario
     *
     * @param id
     */
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Encuentra al usuario por su username
     *
     * @param username
     * @return
     */
    public User findByUsername(String username){

        return this.userRepository.findByUsername(username).orElseThrow(
                () -> new ServiceException("No se ha encontrado el usuario", HttpStatus.NOT_FOUND));
    }

    /**
     * Devuelve las authorities del usuario
     *
     * @param userId
     * @return
     */
    @Override
    public List<String> getAuthorities(Long userId) {

        User user = findById(userId);
        return user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
    }

    /**
     * Actualiza la imagen de perfil del usuario
     *
     * @param user
     * @param id
     * @return
     */
    @Override
    public User updateImagenUser(User user, Long id) {

        // Verifica si el usuario que se está actualizando es el mismo que se proporciona en el cuerpo de la solicitud
        if (user.getIdUser() == null || !user.getIdUser().equals(id)) {
            throw new ServiceException("Usuario debe coincidir con el usuario que se va a modificar", HttpStatus.BAD_REQUEST);
        }

        User realUser = findById(id);

        realUser.setImg(user.getImg());

        // Realiza la actualización del usuario en la base de datos
        return update(realUser);
    }

    /**
     * Cambia las authorities del usuario
     *
     * @param user
     * @param userId
     * @return
     */
    @Override
    public User changeAuthorities(User user, Long userId) {

        if (!user.getAuthorities().contains(UserAuthority.ADMIN)){
            throw new ServiceException("El usuario no tiene los permisos para esta solicitud", HttpStatus.BAD_REQUEST);
        }

        User changeUser = findById(userId);
        List<UserAuthority> userAuthorityList = new ArrayList<>();
        userAuthorityList.add(UserAuthority.ADMIN);
        changeUser.setAuthorities(userAuthorityList);
        return update(changeUser);
    }

    /**
     * Encuentra al usuario por el nombre o por el email
     *
     * @param username
     * @param email
     * @return
     */
    @Override
    public User findByUsernameOrEmail(String username, String email) {
        return this.userRepository.findByUsernameOrEmail(username, email).orElseThrow(
                () -> new ServiceException("No se ha encontrado el usuario", HttpStatus.NOT_FOUND));
    }

    /**
     * Devuelve el cliente del usuario
     *
     * @param id
     * @return
     */
    @Override
    public Client getClient(Long id) {
        User user = findById(id);
        return user.getClient();
    }
}
