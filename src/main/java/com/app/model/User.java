package com.app.model;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User entity class
 *
 * @author Eugene Kurbatov
 */
@Entity(name = "user")
public class User {

    private int id;

    private String login;

    private String password;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "login") @Basic
    public  String getLogin() {
        return login;
    }

    @RequiredStringValidator(key = "login.required")
    public  void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password") @Basic
    public  String getPassword() {
        return password;
    }

    @RequiredStringValidator(key = "password.required")
    @StringLengthFieldValidator(message = "Password: min length 6", minLength = "6",  maxLength = "255")
    public void setPassword(String password) {
        this.password = password;
    }
}
