package com.apt.billsplitter.datamodel.domain;

import lombok.Data;

@Data
public class ErrorMessage {
    private boolean errorStatus;
    private String errorMessage = "";
}
