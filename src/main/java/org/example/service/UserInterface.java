package org.example.service;

import org.example.model.User;

public interface UserInterface {

    User createUser(String userName);
    User readUser(String accountId);

}
