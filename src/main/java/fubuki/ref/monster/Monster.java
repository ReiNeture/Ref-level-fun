package fubuki.ref.monster;

import java.math.BigDecimal;

import fubuki.ref.combat.TakeDamage;
import fubuki.ref.util.Randoms;
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
	
	public Monster() {
		this.name = this.getClass().getSimpleName();
	}
	
	public TakeDamage handleTakeDamage() {
		return normalAttack();
	}
	
	protected TakeDamage normalAttack() {
		BigDecimal iDamage = Randoms.defaultFloatDamage(this.damage);
		String text = String.format("%s 普通攻擊造成 %s 傷害", this.name, iDamage);
		return new TakeDamage(iDamage, text);
	}
	
}
