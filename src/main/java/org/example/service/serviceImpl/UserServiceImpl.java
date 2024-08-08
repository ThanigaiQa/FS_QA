package org.example.service.serviceImpl;

import org.example.model.User;
import org.example.service.ExcelService;
import org.example.service.UserInterface;
import java.util.Random;

public class UserServiceImpl implements UserInterface {
    private final ExcelService excelService;

    public UserServiceImpl(String excelService) {
        this.excelService = new ExcelServiceImpl(excelService);
    }

    @Override
    public User createUser(String userName) {
        User userExist = excelService.readUser(userName);
        if (userExist != null) {
            return userExist;
        }
        String userId = generateAccountId();
        User user = new User(userId, userName);
        excelService.write(user);
        return user;
    }

    @Override
    public User readUser(String accountId) {
        return excelService.readUser(accountId);
    }

    private String generateAccountId() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < 15; i++ ){
            int n = random.nextInt(10);
            stringBuilder.append(n);
        }
        return stringBuilder.toString();
    }

}
