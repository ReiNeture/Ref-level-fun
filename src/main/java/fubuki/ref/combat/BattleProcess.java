package fubuki.ref.combat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fubuki.ref.character.Characters;
import fubuki.ref.monster.Monster;

@Component
public class BattleProcess {
	
	@Autowired
	CombatRepository combatRepository;
	
	public void battle(Characters attack, Monster victim) {
	
		int round = 1;
		StringBuffer history = new StringBuffer();
		
		BigDecimal idHealth = BigDecimal.valueOf(100 + attack.getLevel() * 10);
		BigDecimal idDamage = getCharacterDamage(attack);
		
		BigDecimal mHealth = victim.getHealth();
		BigDecimal mDamage = victim.getDamage();
		
		while( idHealth.compareTo(BigDecimal.ZERO) > 0 && mHealth.compareTo(BigDecimal.ZERO) > 0  ) {
			
			if( isCharactersRound(round) ) {
				
				BigDecimal iDamage = getCausedDamage(idDamage);
				mHealth = mHealth.subtract(iDamage);
				
				history.append(String.format("%s -%s HP", victim.getName(), iDamage) );
				history.append(System.lineSeparator());
				
			} else {
				
				BigDecimal iDamage = getCausedDamage(mDamage);
				idHealth = idHealth.subtract(iDamage);
				
				history.append(String.format("YOU -%s HP", iDamage) );
				history.append(System.lineSeparator());
			}
			
			round++;
		}
		
		Combat result = Combat.builder()
								.monsterName(victim.getName())
								.playerId(attack.getId())
								.startTime(LocalDateTime.now())
								.endTime(LocalDateTime.now().plusSeconds(victim.getNeedTime()))
								.history(history.toString())
								.victory(idHealth.compareTo(BigDecimal.ZERO) > 0)
							.build();
		
		combatRepository.save(result);
	}
	
	private BigDecimal getCharacterDamage(Characters chars) {
		return BigDecimal.valueOf(70 + chars.getLevel() * 2);
	}
	
	private BigDecimal nextFloatBetween(float min, float max) {
	    return BigDecimal.valueOf((new Random().nextFloat() * (max - min)) + min);
	}
	
	private BigDecimal getCausedDamage(BigDecimal baseDamage) {
		return baseDamage.add(
					baseDamage.multiply(
							nextFloatBetween(0.0f, 0.3f)
					)).setScale(0, RoundingMode.HALF_UP);
	}
	
	private boolean isCharactersRound(int round) {
		return round % 2 > 0;
	}
}
