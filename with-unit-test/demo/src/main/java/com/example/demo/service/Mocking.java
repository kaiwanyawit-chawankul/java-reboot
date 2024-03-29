package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.infra.ApplicationDao;

public class Mocking {
    User user;

    public void setUser(User user) {
        this.user = user;
    }

    public int assignPermission() {
        if(user.getRole().equals("admin")) {
            String username = user.getUsername();
            System.out.println("Assign special permissions for user " + username);
            return 1;
        } else {
            System.out.println("Cannot assign permission");
            return -1;
        }
    }

    public int updateUsername(String id, String username) throws Exception{
            ApplicationDao applicationDao = new ApplicationDao();
            User user = applicationDao.getUserById(id);
            if(user!=null)
                user.setUsername(username);
            applicationDao.save(user);
            return 1;
    }
}
