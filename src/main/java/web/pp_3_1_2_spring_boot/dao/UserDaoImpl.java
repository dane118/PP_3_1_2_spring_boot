package web.pp_3_1_2_spring_boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.pp_3_1_2_spring_boot.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void addNewUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        User userCheck = entityManager.find(User.class, user.getId());
        if (userCheck == null) {
            throw new EntityNotFoundException();
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public User getById(Long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException();
        } else {
            return user;
        }
    }

    @Override
    public void deleteUser(User user) {
        if (!entityManager.contains(user)) {
            throw new EntityNotFoundException();
        } else {
            entityManager.remove(user);
        }
    }
}
