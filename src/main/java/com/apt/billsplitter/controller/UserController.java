package com.apt.billsplitter.controller;

import com.apt.billsplitter.business.AptBillSplitter;
import com.apt.billsplitter.datamodel.domain.LoginMessage;
import com.apt.billsplitter.entity.AptUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private AptBillSplitter aptBillSplitter;


    @PostMapping(value = "register", consumes = "application/json")
    public LoginMessage registerUser(@RequestBody AptUser aptUser) {
        log.info("register user: {} {}", aptUser.getFirstName(), aptUser.getLastName());
        return aptBillSplitter.registerNewMessage(aptUser);
    }
}
