package com.hillel.ua.page_object.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SportChekRegisterErrorsModel {

    public SportChekRegisterErrorsModel() {
    }

    private String EmailError;
    private String ConfirmEmailError;
    private String PasswordError;
    private String ConfirmPasswordError;
}
