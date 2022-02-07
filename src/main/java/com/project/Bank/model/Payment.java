package com.project.Bank.model;

import com.project.Bank.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Payment {
    private long id;
    private LocalDateTime date;
    private BigDecimal amount;
    private long debitAccountId;
    private long creditAccountId;
    private String description;
    private Status status;

    public Payment(long id, LocalDateTime date, BigDecimal amount, long debitAccountId, long creditAccountId, String description, Status status) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.debitAccountId = debitAccountId;
        this.creditAccountId = creditAccountId;
        this.description = description;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getDebitAccountId() {
        return debitAccountId;
    }

    public void setDebitAccountId(long debitAccountId) {
        this.debitAccountId = debitAccountId;
    }

    public long getCreditAccountId() {
        return creditAccountId;
    }

    public void setCreditAccountId(long creditAccountId) {
        this.creditAccountId = creditAccountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id &&
                debitAccountId == payment.debitAccountId
                && creditAccountId == payment.creditAccountId &&
                Objects.equals(date, payment.date) &&
                Objects.equals(amount, payment.amount) &&
                Objects.equals(description, payment.description) &&
                status == payment.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, amount, debitAccountId, creditAccountId, description, status);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", debitAccountId=" + debitAccountId +
                ", creditAccountId=" + creditAccountId +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
