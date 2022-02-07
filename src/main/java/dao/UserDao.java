package dao;


import com.project.Bank.model.User;

import java.util.List;

public interface UserDao {
    //create
    void add(User user);

    //read
    List<User> getAll();

    User getById(Long id);

    //update
    void update(User user);

    //delete
    void remove(User user);
}
