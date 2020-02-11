package com.hillel.ua.page_object.model;

import lombok.Data;

@Data
public class SportChekUserRegistrationModel {

    private String Email;
    private String ConfirmEmail;
    private String Password;
    private String ConfirmPassword;
}
