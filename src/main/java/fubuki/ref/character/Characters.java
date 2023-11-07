package fubuki.ref.character;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
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
	
	public Characters(long id) {
		this.id = id;
	}
	
	public void addExperience(int reward) {
		this.exp += reward;
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
}
