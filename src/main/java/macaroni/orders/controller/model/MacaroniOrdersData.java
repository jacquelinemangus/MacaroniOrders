package macaroni.orders.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import macaroni.orders.entity.Cheese;
import macaroni.orders.entity.Customer;
import macaroni.orders.entity.MacaroniOrders;

@Data
@NoArgsConstructor
public class MacaroniOrdersData {
	private Long macaroniOrdersId;
	private Long noodleShapeid;
	private String herbToppingtype;
	private Set<MacaroniOrdersCheese> cheeses = new HashSet<>();
	private Set<MacaroniOrdersCustomerData> customers = new HashSet<>();

	public MacaroniOrdersData(MacaroniOrders macaroniOrders) {
		macaroniOrdersId = macaroniOrders.getMacaroniOrderid();
		noodleShapeid = macaroniOrders.getNoodleShapeid();

		herbToppingtype = macaroniOrders.getHerbToppingChoice();

//		for (Customer customer : macaroniOrders.getCustomers()) {
//			customers.add(new MacaroniOrdersCustomerData(customer));
//		}

		for (Cheese cheese : macaroniOrders.getCheese()) {
			cheeses.add(new MacaroniOrdersCheese(cheese));
		}

	}

}
