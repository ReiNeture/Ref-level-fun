package fubuki.ref.monster;

import java.math.BigDecimal;

import lombok.Data;

@Data
public abstract class Monster {

	private String name;
	private String image;
	
	private int level;
	private int exp;
	private int coin;
	
	private BigDecimal damage;
	private BigDecimal health;
	
	private int needTime;
}
