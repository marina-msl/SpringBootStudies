package com.mml.mvctest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mml.mvctest.dto.RequestNewOrder;
import com.mml.mvctest.model.Order;
import com.mml.mvctest.repository.OrderRepository;

@Controller
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("form")
	public String form(RequestNewOrder requestNewOrder) {
		return "order/form";
	}
	
	@PostMapping("new")
	public String newOrder(@Valid RequestNewOrder requestNewOrder, BindingResult result){
		if(result.hasErrors()) {
			return "order/form";
		}
		Order order = requestNewOrder.toOrder();
		orderRepository.save(order);
		return "redirect:/home";
	}

}
