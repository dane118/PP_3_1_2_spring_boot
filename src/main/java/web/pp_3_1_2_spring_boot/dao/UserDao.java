package web.pp_3_1_2_spring_boot.dao;

import web.pp_3_1_2_spring_boot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getById(Long id);

    void deleteUser(User user);

    void updateUser(User user);

    void addNewUser(User user);
}
