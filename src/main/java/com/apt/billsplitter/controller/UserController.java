package com.apt.billsplitter.controller;

import com.apt.billsplitter.business.AptBillSplitter;
import com.apt.billsplitter.datamodel.domain.LoginMessage;
import com.apt.billsplitter.entity.AptUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private AptBillSplitter aptBillSplitter;

    @PostMapping("send/code/activation")
    public String sendActivationCode(@RequestParam String email, @RequestParam String phoneNumber) {
        log.info("sending activation code for: {}", email);
        return aptBillSplitter.sendActivationCode(email, phoneNumber);
    }

    @PostMapping("send/code/verify")
    public String checkIfVerificationCodeIsValid(@RequestParam String activationCode,
                                                 @RequestParam String email, @RequestParam String phoneNumber) {
        log.info("sending verification for user with email {} and phone number: {}", email, phoneNumber);
//        return aptBillSplitter.verifyActivationCode(activationCode, email, phoneNumber);
        return "true";
    }


    @PostMapping(value = "register", consumes = "application/json")
    public LoginMessage registerUser(@RequestBody AptUser aptUser) {
        log.info("register user: {} {}", aptUser.getFirstName(), aptUser.getLastName());
        return aptBillSplitter.registerNewMessage(aptUser);
    }
}
