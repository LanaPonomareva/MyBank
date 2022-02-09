package com.project.Bank.dao.impl;

import com.project.Bank.dao.CardDao;
import com.project.Bank.model.Card;
import com.project.Bank.model.enums.CardCondition;
import com.project.Bank.model.enums.CardName;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CardDaoImpl implements CardDao {

    @Override
    public void create(Card card, Connection connection) throws SQLException {
        String sql = "insert into card (cardName, number, cardCondition, accountId)" +
                "values (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, card.getCardName().toString());
            preparedStatement.setLong(2, card.getNumber());
            preparedStatement.setString(3, card.getCardCondition().toString());
            preparedStatement.setLong(4, card.getAccountId());
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                card.setId(id);
            }
        }

    }


    @Override
    public List<Card> getAll(Connection connection) throws SQLException {
        String query = "select id, cardName, number, cardCondition, accountId FROM card ;";
        List<Card> cards = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Card card = extractCard(resultSet);
                cards.add(card);
            }
        }

        return cards;
    }


    @Override
    public Optional<Card> getById(long id, Connection connection) throws SQLException {
        String sql = "select id, cardName, number, cardCondition, accountId FROM card WHERE id=?;";
        Card card = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    card = extractCard(resultSet);
                }
            }
        }
        return Optional.ofNullable(card);
    }

    @Override
    public void update(Card card, Connection connection) throws SQLException {
        String sql = "update payment " + "set " +
                "cardName = ?, " +
                "number =?," +
                "cardCondition =? ," +
                "accountId =?," +
                "where id =? ;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, card.getCardName().toString());
            preparedStatement.setLong(2, card.getNumber());
            preparedStatement.setString(3, card.getCardCondition().toString());
            preparedStatement.setLong(4, card.getAccountId());
            preparedStatement.setLong(5, card.getId());


        }
    }


    @Override
    public void remove(Card card, Connection connection) throws SQLException {
        String query = "DELETE FROM CARD WHERE ID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, card.getId());
            preparedStatement.executeUpdate();
        }
    }
    private Card extractCard(ResultSet resultSet) throws SQLException {
        Card card = new Card();
        card.setId(resultSet.getLong("id"));
        card.setNumber(resultSet.getLong("number"));
        card.setAccountId(resultSet.getLong("accountId"));
        String cardNameStr = resultSet.getString("cardName");
        CardName cardName = cardNameStr != null ? CardName.valueOf(cardNameStr) : null;
        card.setCardName(cardName);

        String cardConditionStr = resultSet.getString("cardCondition");
        CardCondition cardCondition = cardConditionStr != null ? CardCondition.valueOf(cardConditionStr) : null;
        card.setCardCondition(cardCondition);
        return card;
    }

}

