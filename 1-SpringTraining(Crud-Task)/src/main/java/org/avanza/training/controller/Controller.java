package org.avanza.training.controller;

import org.avanza.training.data.entity.User;
import org.avanza.training.model.RegistrationRequestDTO;
import org.avanza.training.service.RegistrationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/registration")
public class Controller {

    @Autowired
    @Qualifier("RegistrationDefault")
    RegistrationManager registrationManager;

    @GetMapping("/getUsersList")
    public Iterable<User> index() {
        return registrationManager.getAllUsers();
    }

    @PostMapping("/registerUser")
    public String register(@RequestBody RegistrationRequestDTO body) {
        registrationManager.registerUser(body);
        return "User Successfully Registered!";
    }
    @PostMapping("/updateUser")
    public String update(@RequestBody RegistrationRequestDTO body) {
        registrationManager.update(body);
        return "User Successfully Update!";
    }
    @PostMapping("/deleteUser")
    public void delete(@RequestBody RegistrationRequestDTO body) {
        registrationManager.delete(body);
    }

    @GetMapping("{userId}")
    public Optional<User> getUser(@PathVariable Integer userId){
        return this.registrationManager.getUser(userId);
    }
}
