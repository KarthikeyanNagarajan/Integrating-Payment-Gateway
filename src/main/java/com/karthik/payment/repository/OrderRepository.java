package com.karthik.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karthik.payment.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	public Order findByPaymentId(String paymentId);
}
