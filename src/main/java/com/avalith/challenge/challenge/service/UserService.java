package com.avalith.challenge.challenge.service;

import com.avalith.challenge.challenge.Model.User;
import com.avalith.challenge.challenge.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(@Qualifier("userJpa") UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addUser(User u){
        // Dada la complejidad de la construcción podría usarse un builder
        User user = new User(UUID.randomUUID(),
                                u.getUserName(),
                                u.getFullName(),
                                u.getEmail(),
                                LocalDateTime.now(),
                                u.getPassword());
        this.userRepository.save(user);
    }

    public void bulkImport(List<User> users){
        users.forEach(user -> addUser(user));
    }

    public List<User> getAll(){
        return this.userRepository.findAll();
    }

    public User retrieveById(UUID id){
        return this.userRepository.getOne(id);
    }

    public <U> void deleteUser(U user){
        if(user instanceof User)
            this.userRepository.delete((User)user);
        else if(user instanceof UUID)
            this.userRepository.deleteById((UUID)user);
    }

}
