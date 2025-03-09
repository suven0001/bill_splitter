package com.apt.billsplitter.repository;

import com.apt.billsplitter.entity.AptUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AptUserRepository extends MongoRepository<AptUser, String> {
    AptUser findByEmail(String email);
}
