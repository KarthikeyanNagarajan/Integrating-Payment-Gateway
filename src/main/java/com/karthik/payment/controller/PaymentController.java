package com.karthik.payment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.karthik.payment.entity.Order;
import com.karthik.payment.service.PaymentService;
import com.razorpay.RazorpayException;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService orderService;

	@GetMapping("/")
	public String homepage() {
		return "homepage";
	}

	@PostMapping("/createOrder")
	@ResponseBody
	public ResponseEntity<Order> createOrderPayment(@RequestBody Order order) throws RazorpayException {
		Order createdOrder = orderService.createOrderPayment(order);
		System.out.println(createdOrder);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
	}

	@PostMapping("/paymentCallback")
	public String paymentCallback(@RequestParam Map<String, String> razorPayResponse) throws RazorpayException {
		Order updatedOrder = orderService.updateOrderPayment(razorPayResponse);
		System.out.println(updatedOrder);
		return "SuccessPage";
	}
}
