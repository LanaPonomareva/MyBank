package dao;



import com.project.Bank.model.Payment;

import java.util.List;

public interface PaymentDao {
    //create
    void add(Payment payment);

    //read
    List<Payment> getAll();

    Payment getById(Long id);

    //update
    void update(Payment payment);

    //delete
    void remove(Payment payment);
}
