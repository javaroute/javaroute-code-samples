package org.javaroute.mapper;

import org.javaroute.model.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User getUserById(Integer id);
    List<User> getUsers();
    List<User> getUsersByPage(Map map);
    Integer insertUser(User user);
    Integer updateUser(User user);
    Integer deleteUserById(Integer id);
}
