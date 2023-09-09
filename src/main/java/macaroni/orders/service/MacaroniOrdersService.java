package macaroni.orders.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import macaroni.orders.controller.model.MacaroniOrdersCustomerData;
import macaroni.orders.controller.model.MacaroniOrdersData;
import macaroni.orders.dao.CheeseDao;
import macaroni.orders.dao.CustomerDao;
import macaroni.orders.dao.MacaroniOrdersDao;
import macaroni.orders.entity.Customer;
import macaroni.orders.entity.MacaroniOrders;

@Service
@Slf4j
public class MacaroniOrdersService {

	@Autowired
	private MacaroniOrdersDao macaroniOrdersDao;

	@Autowired
	private CheeseDao cheeseDao;

	@Autowired
	private CustomerDao customerDao;

	
	public MacaroniOrdersData saveMacaroniOrders(MacaroniOrdersData macaroniOrdersData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	public List<MacaroniOrdersData> retrieveAllMacaroniOrders() {
		List<MacaroniOrders> macaroniorders = macaroniOrdersDao.findAll();
		List<MacaroniOrdersData> result = new LinkedList<>();
		
		for(MacaroniOrders macaroniOrders : macaroniorders) {
			MacaroniOrdersData mod = new MacaroniOrdersData(macaroniOrders);
	
			
			mod.getCheeses().clear();
			mod.getCustomers().clear();

		}
		return result;		
}

	@Transactional
	public MacaroniOrdersData retrieveMacaroniOrdersById(Long macaroniOrdersId) {
		MacaroniOrders macaroniorders = findMacaroniOrdersById(macaroniOrdersId);
		return new MacaroniOrdersData(macaroniorders);
	}

	private MacaroniOrders findMacaroniOrdersById(Long macaroniOrderId) {
		return macaroniOrdersDao.findById(macaroniOrderId)
				.orElseThrow(() -> new NoSuchElementException("Macaroni orders with ID=" + " does not exist."));
	}

	@Transactional(readOnly = false)
	public void deleteMacaroniOrdersById(Long macaroniOrderId) {
		MacaroniOrders macaroniOrders = findMacaroniOrdersById(macaroniOrderId);
		macaroniOrdersDao.delete(macaroniOrders);
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
