package com.apt.billsplitter.service;

import com.apt.billsplitter.entity.AptUser;
import com.apt.billsplitter.repository.AptUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AptUserService {

    @Autowired
    private AptUserRepository aptUserRepository;

    public String registerUser(AptUser aptUser) throws Exception {
        log.info("registering new user : {}", aptUser.getFirstName());
        AptUser savedUser = aptUserRepository.save(aptUser);
        return savedUser.getId();
    }

    public boolean checkIfUserExists(String email) throws Exception {
        log.info("checking if user exists : {}", email);
        return aptUserRepository.findByEmail(email) != null;
    }
}
