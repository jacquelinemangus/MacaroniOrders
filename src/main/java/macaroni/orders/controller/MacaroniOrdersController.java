package macaroni.orders.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import macaroni.orders.controller.model.MacaroniOrdersCustomerData;
import macaroni.orders.controller.model.MacaroniOrdersData;
import macaroni.orders.service.MacaroniOrdersService;

@RestController
@RequestMapping("/macaroni_orders")
@Slf4j
public class MacaroniOrdersController {
	@Autowired
	private MacaroniOrdersService macaroniOrdersService;
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MacaroniOrdersController.class);

	@PostMapping("/macaroniOrders")
	@ResponseStatus(code = HttpStatus.CREATED)
	public MacaroniOrdersData insertMacaroniOrders(@RequestBody MacaroniOrdersData macaroniOrdersData) {
		log.info("Creating order {}", macaroniOrdersData);
		return macaroniOrdersService.saveMacaroniOrders(macaroniOrdersData);
	}

	@PutMapping("/macaroniOrders/{macaroniOrdersId}")
	public MacaroniOrdersData updateMacaroniOrders(@PathVariable Long macaroniOrdersId,
			@RequestBody MacaroniOrdersData macaroniOrdersData) {
		macaroniOrdersData.setMacaroniOrdersId(macaroniOrdersId);
		log.info("Updating macaroniOrders {}", macaroniOrdersData);
		return macaroniOrdersService.saveMacaroniOrders(macaroniOrdersData);
	}

	@GetMapping("/macaroniOrders")
	public List<MacaroniOrdersData> retrieveAllMacaroniOrders() {
		log.info("Retrieve all macaroni orders called.");
		return macaroniOrdersService.retrieveAllMacaroniOrders();
	}

	@GetMapping("macaroniOrders/{macaroniOrdersId}")
	public MacaroniOrdersData retrieveMacaroniOrdersById(@PathVariable Long macaroniOrdersId) {
		log.info("Retrieving macaroni orders with Id ={}", macaroniOrdersId);
		return macaroniOrdersService.retrieveMacaroniOrdersById(macaroniOrdersId);
	}

	@DeleteMapping("/{macaroniOrdersId}")
	public Map<String, String> deleteMacaroniOrderById(@PathVariable Long macaroniOrdersId) {
		log.info("Deleting order with ID", macaroniOrdersId);

		macaroniOrdersService.deleteMacaroniOrdersById(macaroniOrdersId);
		return Map.of("message", "successful deletion of Macaroni Order Id.");
	}
	
	/**
	 * BRW
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/customer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public MacaroniOrdersCustomerData createCustomer(@RequestBody MacaroniOrdersCustomerData macaroniOrdersCustomerData) {
		log.info("Creating customer {}", macaroniOrdersCustomerData);
		return macaroniOrdersService.saveCustomer(macaroniOrdersCustomerData);
	}
}