package com.project.Bank.dao.impl;

import com.project.Bank.dao.UserDao;
import com.project.Bank.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    @Override
    public void create(User user, Connection connection) throws SQLException {
        String sql =
                "insert into users (firstName, lastName, email, password, isActive)" +
                        "values (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setBoolean(5, user.isActive());
            preparedStatement.setString(6, user.getRole().toString());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                user.setId(id);
            }
        }
    }


    @Override
    public Optional<User> getById(Long id, Connection connection) throws SQLException {
        String query = "select id, firstName, lastName, email, password, isActive FROM users WHERE id = ?;";
        User user = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = extractUser(resultSet);
                }
            }

        }
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> getAll(Connection connection) throws SQLException {
        String query = "select id, firstName, lastName, email, password, isActive FROM users ;";
        List<User> users = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                User user = extractUser(resultSet);
                users.add(user);
            }
        }

        return users;
    }


    @Override
    public void update(User user, Connection connection) throws SQLException {
        String sql = "update users" +
                "set " + "firstName = ?, " +
                "lastName =?," +
                "email =? ," +
                "password =?," +
                "isActive =? " +
                "where id =? ;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setBoolean(5, user.isActive());
            preparedStatement.setString(6, user.getRole().toString());
            preparedStatement.setLong(7, user.getId());
            preparedStatement.execute();
        }

    }


    @Override
    public void remove(User user, Connection connection) throws SQLException {
        String query = "DELETE FROM USER WHERE ID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeUpdate();
        }
    }

    private User extractUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setFirstName(resultSet.getString("firstName"));
        user.setLastName(resultSet.getString("lastName"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setActive(resultSet.getBoolean("isActive"));
        return user;


    }
}

