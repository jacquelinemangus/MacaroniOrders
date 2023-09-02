package macaroni.orders.entity;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class MacaroniOrders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long macaroniOrderid;
	private Long noodleShapeid;
	private String herbToppingChoice;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "cheese_order", joinColumns = @JoinColumn(name = "cheese_id"))
	private Set<Cheese> cheese = new HashSet<>();
	
//	@OneToMany(cascade = CascadeType.PERSIST)
//	@JoinTable(name = "customer", joinColumns = @JoinColumn(name = "customer_id"))
//	private Set<Customer> customers = new HashSet<>();
}
