package task.service;

import org.springframework.stereotype.Component;
import task.dao.UserDao;
import task.model.User;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void removeById(Long id) {
        userDao.removeById(id);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }
}
