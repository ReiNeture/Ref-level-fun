package fubuki.ref.monster;

import java.math.BigDecimal;

public class Rabbit extends Monster {

	public Rabbit() {
		super();
		this.setLevel(1);
		this.setHealth(BigDecimal.valueOf(100.0));
		this.setDamage(BigDecimal.valueOf(2.0));
		this.setExp(10000);
		this.setCoin(10);
		this.setImage("/images/aqua.png");
		this.setNeedTime(1);
	}
}
