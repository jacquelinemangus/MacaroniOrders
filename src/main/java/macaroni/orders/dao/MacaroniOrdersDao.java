package macaroni.orders.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import macaroni.orders.entity.MacaroniOrders;

public interface MacaroniOrdersDao extends JpaRepository<MacaroniOrders, Long> {

}
