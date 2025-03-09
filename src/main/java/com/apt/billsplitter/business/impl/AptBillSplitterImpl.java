package com.apt.billsplitter.business.impl;

import com.apt.billsplitter.business.AptBillSplitter;
import com.apt.billsplitter.datamodel.domain.LoginMessage;
import com.apt.billsplitter.datamodel.emums.VerificationMessageEnum;
import com.apt.billsplitter.entity.AptUser;
import com.apt.billsplitter.service.AptUserService;
import com.apt.billsplitter.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class AptBillSplitterImpl implements AptBillSplitter {

    @Autowired
    private AptUserService aptUserService;

    @Autowired
    private EmailService emailService;

    @Override
    public LoginMessage registerNewMessage(AptUser aptUser) {
        LoginMessage loginMessage = new LoginMessage();
        try {
            String userId = null;
            log.info("register new message");
            if (aptUser != null && aptUser.getEmail() != null && !aptUser.getEmail().isEmpty()
                    && aptUser.getPassword() != null && !aptUser.getPassword().isEmpty()) {
                //check if user already exists
                boolean userExists = aptUserService.checkIfUserExists(aptUser.getEmail());
                if (userExists) {
                    log.info("user already exist exists");
                    loginMessage.setErrorMessage("user already exists");
                    loginMessage.setErrorStatus(true);
                } else {
                    userId = aptUserService.registerUser(aptUser);
                    if (userId != null) {
                        loginMessage.setLoginMessage("successful");
                    } else {
                        loginMessage.setErrorMessage("failed");
                        loginMessage.setErrorStatus(true);
                    }
                }
            }
        } catch (Exception e) {
            log.error("error while registering new user", e);
            loginMessage.setErrorMessage(e.getMessage());
            loginMessage.setErrorStatus(true);
        }
        return loginMessage;
    }

    @Override
    public String sendActivationCode(String email, String phoneNumber) {
        String subject = "Activation code";
        String body = "AptBillSplitter-Activation code: " + generateActivationCode();
        if (email != null && !email.isEmpty()) {
            boolean isEmailSent = emailService.sendEmail(email, subject, body);
            if (isEmailSent)
                return VerificationMessageEnum.SUCCESS.getMessage();
            else
                return VerificationMessageEnum.FAILURE.getMessage();
        } else if (phoneNumber != null && !phoneNumber.isEmpty()) {
            //send sms
            return generateActivationCode();
        } else {
            return VerificationMessageEnum.NOT_ACTIVATED.getMessage();
        }
    }

    @Override
    public boolean verifyActivationCode(String activationCode, String email, String phoneNumber) {
        return false;
    }

    private String generateActivationCode() {
        Random rand = new Random();
        int activationCode = 100000 + rand.nextInt(900000);
        return String.valueOf(activationCode);
    }
}
