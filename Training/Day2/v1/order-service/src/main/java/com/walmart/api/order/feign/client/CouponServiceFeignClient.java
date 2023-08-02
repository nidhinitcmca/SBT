package com.walmart.api.order.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.walmart.api.order.rest.response.CouponResponse;


@FeignClient(name="coupon-service",url="http://localhost:8080")
public interface CouponServiceFeignClient {
	
	@GetMapping("/api/coupon/{id}")
	public CouponResponse findDiscountByCouponId(@PathVariable String id);
}
