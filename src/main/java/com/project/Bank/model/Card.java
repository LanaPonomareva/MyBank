package com.project.Bank.model;

import com.project.Bank.enums.CardCondition;
import com.project.Bank.enums.CardName;

import java.util.Objects;

public class Card {
    private long id;
    private CardName cardName;
    private long number;
    private CardCondition cardCondition;
    private long accountId;

    public Card(long id, CardName cardName, long number, CardCondition cardCondition, long accountId) {
        this.id = id;
        this.cardName = cardName;
        this.number = number;
        this.cardCondition = cardCondition;
        this.accountId = accountId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CardName getCardName() {
        return cardName;
    }

    public void setCardName(CardName cardName) {
        this.cardName = cardName;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public CardCondition getCardCondition() {
        return cardCondition;
    }

    public void setCardCondition(CardCondition cardCondition) {
        this.cardCondition = cardCondition;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id == card.id &&
                number == card.number &&
                accountId == card.accountId &&
                cardName == card.cardName &&
                cardCondition == card.cardCondition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardName, number, cardCondition, accountId);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardName=" + cardName +
                ", number=" + number +
                ", cardCondition=" + cardCondition +
                ", accountId=" + accountId +
                '}';
    }
}
