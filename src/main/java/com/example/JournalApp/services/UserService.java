package com.example.JournalApp.services;

import com.example.JournalApp.entities.JournalEntry;
import com.example.JournalApp.entities.User;
import com.example.JournalApp.repositories.JournalEntryRepository;
import com.example.JournalApp.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void saveEntry(User user) {
        userRepository.save(user);
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }
}
