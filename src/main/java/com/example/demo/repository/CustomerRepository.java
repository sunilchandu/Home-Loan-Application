package com.example.demo.repository;

import com.example.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT * FROM customer WHERE id IN (SELECT customer_id FROM loan_application WHERE date_of_application=:dateOfApplication)", nativeQuery = true)
    public List<Customer> findByDateOfApplication(@Param("dateOfApplication") LocalDate dateOfApplication);
}
