package fubuki.ref.monster;

import java.math.BigDecimal;

public class DesertRat extends Monster {

	public DesertRat() {
		super();
		this.setLevel(1);
		this.setHealth(BigDecimal.valueOf(100.0));
		this.setDamage(BigDecimal.valueOf(2.0));
		this.setExp(100);
		this.setCoin(10);
		this.setImage("/monster/desert-rat.jpg");
		this.setNeedTime(120);
	}
}
