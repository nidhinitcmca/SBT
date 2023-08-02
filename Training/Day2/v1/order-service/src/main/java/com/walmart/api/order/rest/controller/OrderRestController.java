package com.walmart.api.order.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.api.order.dao.OrderDao;
import com.walmart.api.order.feign.client.CouponServiceFeignClient;
import com.walmart.api.order.models.Order;
import com.walmart.api.order.rest.response.CouponResponse;

@RestController
public class OrderRestController {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CouponServiceFeignClient feignClient;
	
	@PostMapping("/api/order/")
	public Order placeOrder(@RequestBody Order order) {
		// Fetch couponcode from order 
		String couponCode=order.getCouponCode();
		// From coupon code, fetch applicable dicount
		//To fetch discount, we must call the coupon service.
		//This is a rest call.
		CouponResponse couponResponse=this.feignClient.findDiscountByCouponId(couponCode);
		int discount=couponResponse.getDiscount();
		// Apply the discount to the order object
		order.setPrice(order.getPrice()-discount);
		// Save the order object in the database
		return orderDao.save(order);
		// return order object
		
		
	}
	
}
