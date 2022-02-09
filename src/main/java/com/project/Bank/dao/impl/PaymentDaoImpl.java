package com.project.Bank.dao.impl;

import com.project.Bank.dao.PaymentDao;
import com.project.Bank.model.Payment;
import com.project.Bank.model.enums.Status;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

public class PaymentDaoImpl implements PaymentDao {

    @Override
    public void create(Payment payment, Connection connection) throws SQLException {
        String sql = "insert into payment (date, amount, debitAccountId, creditAccountId, description, status)" +
                "values (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setTimestamp(1, Timestamp.valueOf(payment.getDate()));
            preparedStatement.setBigDecimal(2, payment.getAmount());
            preparedStatement.setLong(3, payment.getDebitAccountId());
            preparedStatement.setLong(4, payment.getCreditAccountId());
            preparedStatement.setString(5, payment.getDescription());
            preparedStatement.setString(6, payment.getStatus().toString());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                payment.setId(id);
            }


        }

    }

    @Override
    public List<Payment> getAll(Connection connection) throws SQLException {
        String query = "select id, date, amount, debitAccountId, creditAccountId, description, status FROM payment ;";
        List<Payment> payments = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Payment payment = extractPayment(resultSet);
                payments.add(payment);
            }
        }

        return payments;
    }


    @Override
    public Optional<Payment> getById(Long id, Connection connection) throws SQLException {
        String sql = "select id, date, amount, debitAccountId, creditAccountId, description, status FROM payment WHERE id=?;";
        Payment payment = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    payment = extractPayment(resultSet);
                }
            }
        }
        return Optional.ofNullable(payment);
    }


    @Override
    public void update(Payment payment, Connection connection) throws SQLException {
        String sql = "update payment " + "set " +
                "date = ?, " +
                "amount =?," +
                "debitAccountId =? ," +
                "creditAccountId =?," +
                "description =? " +
                "status =?" +
                "where id =? ;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setTimestamp(1, Timestamp.valueOf(payment.getDate()));
            preparedStatement.setBigDecimal(2, payment.getAmount());
            preparedStatement.setLong(3, payment.getDebitAccountId());
            preparedStatement.setLong(4, payment.getCreditAccountId());
            preparedStatement.setString(5, payment.getDescription());
            preparedStatement.setString(6, payment.getStatus().toString());
            preparedStatement.setLong(7, payment.getId());
            preparedStatement.executeUpdate();

        }
    }

    @Override
    public void remove(Payment payment, Connection connection) throws SQLException {
        String query = "DELETE FROM PAYMENT WHERE ID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, payment.getId());
            preparedStatement.executeUpdate();
        }
    }

    private Payment extractPayment(ResultSet resultSet) throws SQLException {
        Payment payment = new Payment();
        payment.setId(resultSet.getLong("id"));
        payment.setDebitAccountId(resultSet.getLong("debitAccountId"));
        payment.setCreditAccountId(resultSet.getLong("creditAccountId"));
        payment.setDescription(resultSet.getString("description"));
        payment.setStatus(Status.valueOf(resultSet.getString("status")));


        Timestamp dateTs = resultSet.getTimestamp("date");
        LocalDateTime creationDate = LocalDateTime.ofInstant(dateTs.toInstant(), TimeZone.getDefault().toZoneId());
        payment.setDate(creationDate);

        BigDecimal bigDecimal = resultSet.getBigDecimal("amount");
        payment.setAmount(bigDecimal);

        return payment;

    }
}



