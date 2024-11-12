package com.pbcompass.park_api.services;

import com.pbcompass.park_api.entities.User;
import com.pbcompass.park_api.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    public User updatePassword(Long id, String currentPassword, String newPassword, String confirmPassword){
        if (!newPassword.equals(confirmPassword)){
            throw new RuntimeException("The new password and confirmation field are not equals");
        }

        User user = findById(id);
        if (!user.getPassword().equals(currentPassword)){
            throw new RuntimeException("Your password does not match");
        }
        user.setPassword(newPassword);
        return user;
    }

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
