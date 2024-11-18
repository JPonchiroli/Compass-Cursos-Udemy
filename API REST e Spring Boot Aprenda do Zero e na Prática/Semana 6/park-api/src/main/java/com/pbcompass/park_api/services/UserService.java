package com.pbcompass.park_api.services;

import com.pbcompass.park_api.exception.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pbcompass.park_api.entities.User;
import com.pbcompass.park_api.repositories.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User save(User user) {
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e ) {
            throw new UsernameUniqueViolationException(String.format("Username {%s} already registered", user.getUsername()));
        }

    }

    @Transactional
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("User id={%s} not found", id)));
    }

    @Transactional
    public User updatePassword(Long id, String currentPassword, String newPassword, String confirmPassword){
        if (!newPassword.equals(confirmPassword)) {
            throw new PasswordConfirmationMismatchException("The new password and confirmation field are not equals");
        }

        User user = findById(id);
        if (!user.getPassword().equals(currentPassword)) {
            throw new PasswordMismatchException("Your password does not match");
        }

        if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
            throw new EmptyPasswordException("Your new password must be write");
        }

        user.setPassword(newPassword);
        return user;
    }

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
