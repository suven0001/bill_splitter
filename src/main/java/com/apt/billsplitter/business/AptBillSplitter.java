package com.apt.billsplitter.business;

import com.apt.billsplitter.datamodel.domain.LoginMessage;
import com.apt.billsplitter.entity.AptUser;
import org.springframework.stereotype.Component;

@Component
public interface AptBillSplitter {
    LoginMessage registerNewMessage(AptUser user);
}
