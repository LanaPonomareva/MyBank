package service;

import busnessLogic.ConnectionManager;
import com.project.Bank.model.Account;
import dao.AccountDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountService extends ConnectionManager implements AccountDAO {
    Connection connection = getConnection();
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NUMBER = "number";
    private static final String COLUMN_BALANCE = "balance";
    private static final String COLUMN_IS_ACTIVE = "isActive";
    private static final String COLUMN_USER_ID = "user_id";
    @Override
    public void add(Account account) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO ACCOUNT (COLUMN_ID, COLUMN_NUMBER, COLUMN_BALANCE, COLUMN_IS_ACTIVE, COLUMN_USER_ID) VALUES(?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, account.getId());
            preparedStatement.setString(2, account.getNumber());
            preparedStatement.setObject(3, account.getBalance());
            preparedStatement.setLong(4, account.getUserId());
            preparedStatement.setBoolean(5, account.isActive());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }

    }

    @Override
    public List<Account> getAll() throws SQLException {
        List<Account> accountsList = new ArrayList<>();
        String sql = "SELECT COLUMN_ID, COLUMN_NUMBER, COLUMN_BALANCE, COLUMN_IS_ACTIVE, COLUMN_USER_ID FROM ACCOUNT ";
        Statement statement = null;
        try {
            statement =  connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Account account = new Account();
                account.setId(resultSet.getLong("COLUMN_ID"));
                account.setNumber(resultSet.getString("COLUMN_NUMBER"));
                account.setBalance(resultSet.getBigDecimal("COLUMN_BALANCE"));
                account.setActive(resultSet.getBoolean("COLUMN_IS_ACTIVE"));
                account.setUserId(resultSet.getLong("COLUMN_USER_ID"));

                accountsList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }

        return accountsList;
    }

    @Override
    public Account getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT COLUMN_ID, COLUMN_NUMBER, COLUMN_BALANCE, COLUMN_IS_ACTIVE, COLUMN_USER_ID FROM ACCOUNT WHERE ID = ? ";
        Account account = new Account();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            account.setId(resultSet.getLong("COLUMN_ID"));
            account.setNumber(resultSet.getString("COLUMN_NUMBER"));
            account.setBalance(resultSet.getBigDecimal("COLUMN_BALANCE"));
            account.setActive(resultSet.getBoolean("COLUMN_IS_ACTIVE"));
            account.setUserId(resultSet.getLong("COLUMN_USER_ID"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection !=  null){
                connection.close();
            }
        }
        return account;
    }

    @Override
    public void update(Account account) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE ACCOUNT SET COLUMN_ID, COLUMN_NUMBER, COLUMN_BALANCE, COLUMN_IS_ACTIVE, COLUMN_USER_ID WHERE ID =?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, account.getId());
            preparedStatement.setString(2, account.getNumber());
            preparedStatement.setObject(3, account.getBalance());
            preparedStatement.setBoolean(4, account.isActive());
            preparedStatement.setLong(5, account.getUserId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }if (connection != null){
                connection.close();
            }
        }

    }

    @Override
    public void remove(Account account) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM ACCOUNT WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, account.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }


    }
}
