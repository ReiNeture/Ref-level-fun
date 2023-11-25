package fubuki.ref.equip;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Equip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long wid;
	
	@NotBlank
	private String name;
	
	@Min(0)
	private int attack;
	
	@Min(0)
	private int health;
	
	@Min(0)
	private int cost;
	
	@Min(0)
	private int critical;
	
	private int requireLevel;
	
	@NotNull
	private EquipType type;
	
}
