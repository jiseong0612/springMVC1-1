package hello.springmvc.core.service;

import hello.springmvc.core.domain.Order;

public interface OrderService {
	Order createOrder(Long memberId, String itemName, int itemPrice);
}	
