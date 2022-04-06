package web.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import web.config.model.User;
import web.dao.RoleDao;
import web.dao.UserDao;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;
    private RoleDao roleDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    public UserDetails loadUserByUsername(String username) {
        User user = userDao.getUserByName(username);
        return user;
    }
}
