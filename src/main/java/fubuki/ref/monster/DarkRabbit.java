package fubuki.ref.monster;

import java.math.BigDecimal;

import fubuki.ref.combat.TakeDamage;
import fubuki.ref.util.Randoms;

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
	
	public TakeDamage handleTakeDamage() {
		if( Randoms.Chance(10) )
			return darkClawStrike();
		else
			return normalAttack();
	}

	private TakeDamage darkClawStrike() {
		BigDecimal iDamage = this.getDamage().multiply(BigDecimal.valueOf(2) );
		iDamage = Randoms.defaultFloatDamage(iDamage);
		String text = String.format("%s 使用爪擊技能造成 %s 傷害", this.getName(), iDamage);
		return new TakeDamage(iDamage, text);
	}
}
