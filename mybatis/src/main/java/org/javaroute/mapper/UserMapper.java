package org.javaroute.mapper;

import org.javaroute.model.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User selectUserById(Integer id);
    List<User> selectUsers();
    List<User> selectUsersByPage(Map map);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUserById(Integer id);
}
