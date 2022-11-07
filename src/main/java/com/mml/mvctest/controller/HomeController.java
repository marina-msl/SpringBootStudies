package com.mml.mvctest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mml.mvctest.model.Order;
import com.mml.mvctest.repository.OrderRepository;
import com.mml.mvctest.model.Status;

@RequestMapping("/home")
@Controller
public class HomeController {

	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping()
	public String home(Model model) {
		List<Order> orders = orderRepository.findAll();
		model.addAttribute("orders", orders);
		return "home";
	}
	
	@GetMapping("/{status}")
	public String status(@PathVariable("status") String status, Model model) {
		List<Order> orders = orderRepository.findByStatus(Status.valueOf(status.toUpperCase()));
		model.addAttribute("orders", orders);
		model.addAttribute("status", status);
		return "/home";
	}
	
	@ExceptionHandler(value = {IllegalArgumentException.class})
	public String onError() {
		return "redirect:/home";
	}
}
