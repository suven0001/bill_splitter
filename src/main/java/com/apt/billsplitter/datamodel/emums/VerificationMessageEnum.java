package com.apt.billsplitter.datamodel.emums;

import lombok.Getter;

@Getter
public enum VerificationMessageEnum {
    SUCCESS("Success"),
    FAILURE("Failure"),
    INVALID("Invalid"),
    ALREADY_EXISTS("Already Exists"),
    NOT_FOUND("Not Found"),
    NOT_VERIFIED("Not Verified"),
    VERIFIED("Verified"),
    NOT_ACTIVATED("Not Activated"),
    ACTIVATED("Activated");

    private final String message;
    VerificationMessageEnum(String message) {
        this.message = message;
    }

}
