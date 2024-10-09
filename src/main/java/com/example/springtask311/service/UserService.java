package com.example.springtask311.service;

import com.example.springtask311.model.User;

import java.util.List;

public interface UserService {

    public void saveUser(User user);

    public void updateUser(User user);

    public User getUserById(long id);

    public void deleteUserById(long id);

    public List<User> getAllUsers();

    public void cleanUsersTable();
}
