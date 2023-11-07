package fubuki.ref.model;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fubuki.ref.character.CharacterService;
import fubuki.ref.dao.entity.Player;
import fubuki.ref.dao.reposit.PlayerRepository;
import jakarta.servlet.http.HttpSession;
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
	
	public boolean isLogined(HttpSession session) {
		
		if( Objects.isNull(session.getAttribute("id") ) )
			throw new IllegalStateException("Not Logined");
		if( (long) session.getAttribute("id") < 0 )
			throw new IllegalStateException("Not Logined");
		
		return true;
	}
	
}
