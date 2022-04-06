package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
    }
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        List<User> resultList = entityManager.createQuery("SELECT U FROM User u", User.class).getResultList();
        return resultList;
    }
    @Transactional
    @Override
    public void save(User user) {
        User managed = entityManager.merge(user);
        entityManager.persist(managed);
    }
    @Transactional
    @Override
    public void delete(User user) {
    User managed = entityManager.merge(user);
    entityManager.remove(managed);
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByName(String username) {
        User user = entityManager.createQuery("SELECT U FROM User U WHERE u.name = :name", User.class)
                .setParameter("name", username)
                .getSingleResult();
        return user;
    }
}
