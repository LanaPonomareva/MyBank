package com.project.Bank.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private long id;
    private String number;
    private BigDecimal balance;
    private long userId;
    private boolean isActive;

    public Account() {
    }

    public Account(long id, String number, BigDecimal balance, long userId, boolean isActive) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.userId = userId;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                userId == account.userId &&
                isActive == account.isActive &&
                Objects.equals(number, account.number) &&
                Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, balance, userId, isActive);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                ", userId=" + userId +
                ", isActive=" + isActive +
                '}';
    }
}
