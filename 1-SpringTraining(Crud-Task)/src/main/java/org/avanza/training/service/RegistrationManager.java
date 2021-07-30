package org.avanza.training.service;

import org.avanza.training.data.entity.User;
import org.avanza.training.model.RegistrationRequestDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface RegistrationManager {
    void registerUser(RegistrationRequestDTO registrationRequestDTO);

    Iterable<User> getAllUsers();
    public void update(@RequestBody RegistrationRequestDTO body);

    public default void delete(@RequestBody RegistrationRequestDTO body) {

    }
    public Optional<User> getUser(Integer userId);

}
