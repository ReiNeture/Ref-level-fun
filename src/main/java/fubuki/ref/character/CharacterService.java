package fubuki.ref.character;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fubuki.ref.combat.Combat;
import fubuki.ref.combat.CombatRepository;

@Service
public class CharacterService {

	@Autowired
	CharacterRepository characterRepository;
	@Autowired
	CombatRepository combatRepository;
	
	public void initCharacter(long id) {
		Characters chars = new Characters(id);
		characterRepository.save(chars);
	}
	
	public Characters getCharacterData(long id) {
		return characterRepository.findById(id).get();
	}
	
	public void saveCharacterData(Characters chars) {
		characterRepository.save(chars);
	}
	
	public boolean isBusy(long pid) {
		Optional<Combat> combat = combatRepository.findByPlayerId(pid);
		if( combat.isPresent() )
			return true;
		else
			return false;
	}
}
