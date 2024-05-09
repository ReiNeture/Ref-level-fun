package fubuki.ref.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fubuki.ref.character.CharacterService;
import fubuki.ref.dao.reposit.PlayerRepository;
import jakarta.transaction.Transactional;

@Service
public class PlayerService {
	
	@Autowired
	PlayerRepository playerReposit;
	@Autowired
	CharacterService characterService;
	
	@Transactional
	public void initPlayer(Player data) {
		Player newPlayer = playerReposit.save(data);
		characterService.initCharacter(newPlayer.getId());
	}
	
	public Player loginPlayer(Player login) {
		return playerReposit.findByUsernameAndPassword(
				login.getUsername(), login.getPassword());
	}
	
}
