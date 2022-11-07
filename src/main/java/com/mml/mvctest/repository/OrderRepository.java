package com.mml.mvctest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mml.mvctest.model.Order;
import com.mml.mvctest.model.Status;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findByStatus(Status status);
	
}	
