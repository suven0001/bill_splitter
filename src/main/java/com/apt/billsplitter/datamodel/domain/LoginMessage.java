package com.apt.billsplitter.datamodel.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoginMessage extends ErrorMessage{
    private String loginMessage ="";
}
