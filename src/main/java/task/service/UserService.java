package task.service;

import task.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> getAll();
    void update(User user);

    void removeById(Long id);

    User getById(Long id);


}
