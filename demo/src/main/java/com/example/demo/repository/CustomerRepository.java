package com.example.demo.repository;

import com.example.demo.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
   /* @Query(value = "SELECT * FROM customer WHERE id IN (SELECT customer_id FROM loan_application WHERE date_of_application=:dateOfApplication)", nativeQuery = true)
    public List<Customer> findByDateOfApplication(@Param("dateOfApplication") LocalDate dateOfApplication);*/
}
