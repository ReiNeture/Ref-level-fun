package fubuki.ref.monster;

import java.math.BigDecimal;

public class Rabbit extends Monster {

	public Rabbit() {
		this.setName("Rabbit");
		this.setLevel(100);
		this.setHealth(BigDecimal.valueOf(300.0));
		this.setDamage(BigDecimal.valueOf(2.0));
		this.setExp(10000);
		this.setCoin(10);
		this.setImage("/images/aqua.png");
		this.setNeedTime(15);
	}
}
