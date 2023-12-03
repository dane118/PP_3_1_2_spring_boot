package web.pp_3_1_2_spring_boot.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import web.pp_3_1_2_spring_boot.dao.UserDao;
import web.pp_3_1_2_spring_boot.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void addOrUpdateUser(User user) {
        userDao.addOrUpdateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }
}
