package macaroni.orders.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import macaroni.orders.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

}
