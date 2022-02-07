package dao;

import com.project.Bank.model.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {

    //create
    void add(Account account) throws SQLException;

    //read
    List<Account> getAll() throws SQLException;

    Account getById(Long id) throws SQLException;

    //update
    void update(Account account) throws SQLException;

    //delete
    void remove(Account account) throws SQLException;
}
