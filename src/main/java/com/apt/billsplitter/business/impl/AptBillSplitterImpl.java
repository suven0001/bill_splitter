package com.apt.billsplitter.business.impl;

import com.apt.billsplitter.business.AptBillSplitter;
import com.apt.billsplitter.datamodel.domain.LoginMessage;
import com.apt.billsplitter.entity.AptUser;
import com.apt.billsplitter.service.AptUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AptBillSplitterImpl implements AptBillSplitter {

    @Autowired
    private AptUserService aptUserService;

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
}
