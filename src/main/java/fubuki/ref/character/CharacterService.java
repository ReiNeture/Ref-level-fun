package fubuki.ref.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

	@Autowired
	CharacterRepository characterRepository;
	
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
	
}
