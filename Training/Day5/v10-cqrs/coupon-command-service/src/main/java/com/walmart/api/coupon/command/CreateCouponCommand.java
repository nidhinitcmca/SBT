package com.walmart.api.coupon.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateCouponCommand {

	@TargetAggregateIdentifier
	private String id;
	private String couponCode;
	private Integer discount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	
}
