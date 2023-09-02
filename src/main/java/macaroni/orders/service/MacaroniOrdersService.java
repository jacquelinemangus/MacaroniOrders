package macaroni.orders.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import macaroni.orders.controller.model.MacaroniOrdersCustomerData;
import macaroni.orders.controller.model.MacaroniOrdersData;
import macaroni.orders.dao.CheeseDao;
import macaroni.orders.dao.CustomerDao;
import macaroni.orders.dao.MacaroniOrdersDao;
import macaroni.orders.entity.Customer;

@Service
@Slf4j
public class MacaroniOrdersService {

	@Autowired
	private MacaroniOrdersDao macaroniOrdersDao;

	@Autowired
	private CheeseDao cheeseDao;

	@Autowired
	private CustomerDao customerDao;

	public List<MacaroniOrdersData> retrieveAllMacaroniOrders;

	public MacaroniOrdersData saveMacaroniOrders(MacaroniOrdersData macaroniOrdersData) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MacaroniOrdersData> retrieveAllMacaroniOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	public MacaroniOrdersData retrieveMacaroniOrdersById(Long macaroniOrdersId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteMacaroniOrdersById(Long macaroniOrdersId) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * BRW
	 */
	public MacaroniOrdersCustomerData saveCustomer(MacaroniOrdersCustomerData macaroniOrdersCustomerData) {
		Customer customer = findOrCreateCustomer(macaroniOrdersCustomerData);
		if(customer == null) {
			customer = copyCustomerDataFields(macaroniOrdersCustomerData);
			customer = customerDao.save(customer);
		} else {
			customer = copyCustomerDataFields(macaroniOrdersCustomerData);
			customer = customerDao.save(customer);
		}
		macaroniOrdersCustomerData = copyCustomerFields(customer);
		return macaroniOrdersCustomerData;
	}

	private Customer findOrCreateCustomer(MacaroniOrdersCustomerData macaroniOrdersCustomerData) {
		Customer customer = null;
		try {
			if(macaroniOrdersCustomerData.getCustomerId() == null) {
				return customer;
			}
			customer = findCustomerById(macaroniOrdersCustomerData.getCustomerId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	private Customer findCustomerById(long customerId) {
		Optional<macaroni.orders.entity.Customer> results = customerDao.findById(customerId);
		Customer customer = results.orElse(null);
		if (customer == null) {
			throw new NoSuchElementException("No Customer exists with the Id : " + customerId);
		} else {
			return customer;
		}
	}
	
	public MacaroniOrdersCustomerData getCustomer(long customerId) {
		MacaroniOrdersCustomerData customerData = null;
		Customer customer = findCustomerById(customerId);
		if(customer != null) {
			customerData = copyCustomerFields(customer);
		}
		return customerData;
	}
	
	private Customer copyCustomerDataFields(MacaroniOrdersCustomerData data) {
		Customer customer = new Customer();

		customer.setCustomerId(data.getCustomerId());
		customer.setCustomerOrder(data.getCustomerOrder());
		customer.setCustomerFirstname(data.getCustomerFirstname());
		customer.setCustomerLastname(data.getCustomerLastname());
		customer.setCustomerEmail(data.getCustomerEmail());
		
		return customer;
	}
	
	private MacaroniOrdersCustomerData copyCustomerFields(macaroni.orders.entity.Customer data) {
		MacaroniOrdersCustomerData customerData = new MacaroniOrdersCustomerData(data);
		return customerData;
	}
}