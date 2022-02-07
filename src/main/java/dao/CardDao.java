package dao;


import com.project.Bank.model.Card;

import java.util.List;

public interface CardDao {
    //create
    void add(Card card);

    //read
    List<Card> getAll();

    Card getById(Long id);

    //update
    void update(Card card);

    //delete
    void remove(Card card);
}
