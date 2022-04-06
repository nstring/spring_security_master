package web.dao;

import web.config.model.Role;

import java.util.List;

public interface RoleDao {
    void save(Role role);

    void delete(Role role);

    Role getRoleByName(String name);

    Role getRoleById(Long id);

    List<Role> allRoles();

    Role getDefaultRole();
}
