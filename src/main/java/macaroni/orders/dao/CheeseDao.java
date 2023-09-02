package macaroni.orders.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import macaroni.orders.entity.Cheese;

public interface CheeseDao extends JpaRepository<Cheese, Long> {

}
