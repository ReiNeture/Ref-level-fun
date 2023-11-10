package fubuki.ref.monster;

import java.math.BigDecimal;

public class DesertCrocodile extends Monster {

	public DesertCrocodile() {
		super();
		this.setLevel(20);
		this.setHealth(BigDecimal.valueOf(1000.0));
		this.setDamage(BigDecimal.valueOf(21.0));
		this.setExp(1000);
		this.setCoin(250);
		this.setImage("/monster/desert-crocodile.jpg");
		this.setNeedTime(7);
	}
}
