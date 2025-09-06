package net.javaguides.springboot.service;
import net.javaguides.springboot.entity.User;
import java.util.List;


public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(User user);
}
