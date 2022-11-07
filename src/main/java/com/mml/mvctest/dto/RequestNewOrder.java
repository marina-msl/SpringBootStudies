package com.mml.mvctest.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.mml.mvctest.model.Order;
import com.mml.mvctest.model.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestNewOrder {
	
	@NotBlank
	private String productName;
	
	@NotBlank
	private String productUrl;
	
	@NotBlank
	private String productImage;
	private String productDescription;
	
	
	public Order toOrder() {
		Order order = new Order();
		order.setName(productName);
		order.setUrl(productUrl);
		order.setImageUrl(productImage);
		order.setDescription(productDescription);
		order.setDate(LocalDate.now());
		order.setStatus(Status.WAITING);
		return order;
	} 

}
