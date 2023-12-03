package web.pp_3_1_2_spring_boot.dao;

import web.pp_3_1_2_spring_boot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addOrUpdateUser(User user);

    User getById(Long id);

    void deleteUser(User user);
}
