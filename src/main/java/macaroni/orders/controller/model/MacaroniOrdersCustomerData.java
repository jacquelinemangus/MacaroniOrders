package macaroni.orders.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import macaroni.orders.entity.Customer;

@Data
@NoArgsConstructor 
public class MacaroniOrdersCustomerData {
private Long customerId;
private Long customerOrder;
private String customerFirstname;
private String customerLastname;
private String customerEmail;


public MacaroniOrdersCustomerData (Customer customer) {
	customerId = customer.getCustomerId();
	customerOrder = customer.getCustomerOrder();
	customerFirstname = customer.getCustomerFirstname();
	customerLastname = customer.getCustomerLastname();
	customerEmail = customer.getCustomerEmail();
}
}