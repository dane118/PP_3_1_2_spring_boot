package web.pp_3_1_2_spring_boot.service;

import web.pp_3_1_2_spring_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addOrUpdateUser(User user);

    void deleteUser(User user);

    User getById(Long id);
}
