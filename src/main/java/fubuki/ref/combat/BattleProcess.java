package fubuki.ref.combat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
		
		BigDecimal idHealth = attack.getCharacterHealth();
		BigDecimal mHealth = victim.getHealth();
		
		while( idHealth.compareTo(BigDecimal.ZERO) > 0 && mHealth.compareTo(BigDecimal.ZERO) > 0  ) {
			
			if( isCharactersRound(round) ) {
				
				TakeDamage msg = attack.handleTakeDamage();
				mHealth = mHealth.subtract(msg.getDamage());
				
				history.append(msg.getDisplayText() );
				history.append(System.lineSeparator() );
				
			} else {
				TakeDamage msg = victim.handleTakeDamage();
				idHealth = idHealth.subtract(msg.getDamage());
				
				history.append(msg.getDisplayText() );
				history.append(System.lineSeparator() );
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
	
	private boolean isCharactersRound(int round) {
		return round % 2 > 0;
	}
	
}
