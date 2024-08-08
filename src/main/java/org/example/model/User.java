package org.example.model;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class User {

    private String accountId;
    private String userName;
    private double balance;

    public User(String accountId, String userName) {
        this.accountId = accountId;
        this.userName = userName;
        this.balance = 0.0;
    }
}
