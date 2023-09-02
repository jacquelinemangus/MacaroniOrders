package macaroni.orders.entity;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import macaroni.orders.controller.model.MacaroniOrdersCheese;

@Entity
@Data
public class Cheese {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long cheeseId;
	private String cheeseType;
	private String cheeseRegion;
	private String cheeseSpicelevel;

	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany(mappedBy = "cheese")
	private Set<MacaroniOrders> macaroniOrders = new HashSet<>();


	
	
	
}

