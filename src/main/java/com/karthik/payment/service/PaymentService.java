package com.karthik.payment.service;

import java.util.Date;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.karthik.payment.entity.Order;
import com.karthik.payment.repository.OrderRepository;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class PaymentService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Value(value = "${razorpay.key.id}")
	private String key;
	
	@Value(value = "${razorpay.key.secret}")
	private String secret;

	public Order createOrderPayment(Order order) throws RazorpayException {

		RazorpayClient razorpayClient = new RazorpayClient(key, secret);
		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount", order.getAmount() * 100);
		orderRequest.put("currency", order.getCurrency());
		orderRequest.put("receipt", order.getEmail());

		com.razorpay.Order razorpayOrder = razorpayClient.orders.create(orderRequest);

		order.setOrderStatus("CREATED");
		order.setPaymentId(razorpayOrder.get("id"));
		order.setPaymentStatus(razorpayOrder.get("status"));
		order.setPaymentCreatedAt(String.valueOf(new Date(System.currentTimeMillis())));
		order.setPaymentUpdatedAt(order.getPaymentCreatedAt());

		System.out.println(razorpayOrder);

		orderRepository.save(order);
		return order;
	}

	public Order updateOrderPayment(Map<String, String> razorPayResponse) {

		String razorpayPaymentId = razorPayResponse.get("razorpay_order_id");

		Order order = orderRepository.findByPaymentId(razorpayPaymentId);
		order.setPaymentStatus("PAYMENT_COMPLETED");
		order.setPaymentUpdatedAt(String.valueOf(new Date(System.currentTimeMillis())));

		orderRepository.save(order);
		return order;

	}
}
