package com.example.ecommerce;

import com.example.ecommerce.exception.ResourceNotFoundException;
import jakarta.persistence.Id;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.ecommerce.exception.ResourceNotFoundException;


@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User with id " + id + " does not exist");
        }
        userRepository.deleteById(id);
    }
    public User getUserById(Long id) {
      return userRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException( "User with id " + id + " does not exist"));
    }
    public User updateUser(Long id, User user) {
        User existing = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("user with id " + id + " does not exist"));
                existing.setUsername(user.getUsername());
                existing.setPassword(user.getPassword());
                existing.setContact(user.getContact());
                existing.setAddress(user.getAddress());
                existing.setRole(user.getRole());
                return userRepository.save(existing);

    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }

}
