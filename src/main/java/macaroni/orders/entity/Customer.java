package macaroni.orders.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	Long customerId;
	
	@Column(name="customer_first_name")
	String customerFirstname;
	
	@Column(name="customer_last_name")
	String customerLastname;
	
	@Column(name="customer_email")
	String customerEmail;


