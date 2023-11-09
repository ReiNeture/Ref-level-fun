package fubuki.ref.combat;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fubuki.ref.character.CharacterService;
import fubuki.ref.character.Characters;
import fubuki.ref.monster.Monster;
import fubuki.ref.monster.MonsterInstanceFactory;
import jakarta.transaction.Transactional;

@Service
public class CombatService {
	
	@Autowired
	CharacterService characterService;
	@Autowired
	CombatRepository combatRepository;
	@Autowired
	BattleProcess battleProcess;
	
	public void combatToMonster(long id, String name) {
		
		Characters chars = characterService.getCharacterData(id);
		Monster monster = MonsterInstanceFactory.getMonsterByName(name);
		
		battleProcess.battle(chars, monster);
	}
	
	@Transactional
	public void applyCombat(Combat combat) {
		
		Characters chars = characterService.getCharacterData(combat.getId() );
		Monster monster = MonsterInstanceFactory.getMonsterByName(combat.getMonsterName() );
	
		chars.addExperience(monster.getExp() );
		chars.addCoin(monster.getCoin() );
		
		characterService.saveCharacterData(chars);
		removeCombat(combat);
	}
	
	public void removeCombat(Combat combat) {
		combatRepository.delete(combat);
	}
	
	public Optional<Combat> getCombatInfo(long id) {
		return combatRepository.findById(id);
	}
	
	public Optional<Combat> getCharacterCombat(long pid) {
		return combatRepository.findByPlayerId(pid);
	}
}
