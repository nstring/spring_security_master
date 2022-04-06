package web.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.config.model.Role;
import web.dao.RoleDao;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleDao roleDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public List<Role> allRoles() {
        return roleDao.allRoles();
    }

    @Override
    public Role getDefaultRole() {
        return roleDao.getDefaultRole();
    }
}
