package fubuki.ref.monster;

import java.math.BigDecimal;

public class DarkRabbit extends Monster {

	public DarkRabbit() {
		super();
		this.setLevel(10);
		this.setHealth(BigDecimal.valueOf(500.0));
		this.setDamage(BigDecimal.valueOf(12.0));
		this.setExp(500);
		this.setCoin(100);
		this.setImage("/monster/dark-rabbit.png");
		this.setNeedTime(35);
	}
}
