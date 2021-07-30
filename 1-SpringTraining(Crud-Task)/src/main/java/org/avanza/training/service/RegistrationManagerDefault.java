package org.avanza.training.service;

import org.avanza.training.data.entity.User;
import org.avanza.training.data.repository.UserRepository;
import org.avanza.training.model.RegistrationRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("RegistrationDefault")
public class RegistrationManagerDefault implements RegistrationManager {

    @Autowired
    UserRepository userRepository;

    @Override
    public void registerUser(RegistrationRequestDTO registrationRequestDTO) {

        User user = new User();
        user.setFirstName(registrationRequestDTO.getFirstName());
        user.setLastName(registrationRequestDTO.getLastName());

        userRepository.save(user);
    }

    @Override
    public Iterable<User> getAllUsers() {
        Iterable<User> UserList = userRepository.findAll();

        return UserList;
    }

    @Override
    public void update(RegistrationRequestDTO body) {
        Optional<User> user = userRepository.findById(body.getId());
        if (user.isPresent()){
            user.get().setFirstName(body.getFirstName());
            user.get().setLastName(body.getLastName());
            userRepository.save(user.get());
        }
    }

    @Override
    public void delete(RegistrationRequestDTO body) {
        userRepository.deleteById(body.getId());
    }

    public Optional<User> getUser(Integer userId) {
    Optional<User> u;
        u = userRepository.findById(userId);
        return u;
    }
}
