package com.example.JournalApp.repositories;

import com.example.JournalApp.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String userName);
}
