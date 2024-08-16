package com.karthik.payment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Order_Table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderId")
	private int orderId;

	@Column(name = "Cust_Name")
	private String name;

	@Column(name = "Cust_Email")
	private String email;

	@Column(name = "Cust_No")
	private String phoneNo;

	@Column(name = "Course_Name")
	private String course;

	@Column(name = "Currency")
	private String currency = "INR";

	@Column(name = "Amount")
	private int amount;

	@Column(name = "OrderStatus")
	private String orderStatus;

	@Column(name = "PaymentStatus")
	private String paymentStatus;

	@Column(name = "PaymentId")
	private String paymentId;

	@Column(name = "Created_Tm")
	private String paymentCreatedAt;

	@Column(name = "Updated_Tm")
	private String paymentUpdatedAt;
}
