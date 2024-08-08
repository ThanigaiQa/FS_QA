package org.example.service;

import org.example.model.User;

public interface ExcelService {
    public void write(User user);
    public User readUser(String userName);
}
