package fubuki.ref.character;

import static fubuki.ref.character.EventType.IDLE;

import java.math.BigDecimal;

import fubuki.ref.combat.TakeDamage;
import fubuki.ref.util.Randoms;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Characters {
	
	@Id
	private long id;
	
	@Min(1)
	private int level = 1;
	
	@Min(0)
	private int exp = 0;
	
	@Min(0)
	private int coin = 0;
	
	@NotNull
	private int lockLevle = 0;
	
	private EventType work = IDLE;
	
	public Characters(long id) {
		this.id = id;
	}
	
	public void addExperience(int reward) {
		this.exp += reward;
		
		while( this.exp >= requiredExp() ) {
			this.exp -= requiredExp();
			addLevel(1);
		}
	}
	
	public void subExperience(int reward) {
		this.exp -= reward;
	}
	
	public void addCoin(int reward) {
		this.coin += reward;
	}
	
	public void subCoin(int reward) {
		this.coin -= reward;
	}
	
	public void addLevel(int reward) {
		this.level += reward;
	}
	
	public int requiredExp() {
		return ExpTable.getRequiredExp(this.level);
	}
	
	public BigDecimal getCharacterDamage() {
		return BigDecimal.valueOf(20 + this.getLevel() * 3);
	}
	
	public BigDecimal getCharacterHealth() {
		return BigDecimal.valueOf(100 + this.getLevel() * 10);
	}
	
	public TakeDamage handleTakeDamage() {
		return normalAttack();
	}
	
	private TakeDamage normalAttack() {
		BigDecimal iDamage = Randoms.defaultFloatDamage(getCharacterDamage() );
		String text = String.format("你普通攻擊造成 %s 傷害", iDamage);
		return new TakeDamage(iDamage, text);
	}
}
