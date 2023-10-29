package fubuki.ref.model;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fubuki.ref.dao.entity.Player;
import fubuki.ref.dao.reposit.PlayerRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class PlayerService {
	
	@Autowired
	PlayerRepository playerReposit;
	
	public void siginPlayer(Player data) {
		playerReposit.save(data);
	}
	
	public void loginPlayer(Player login, HttpSession session) {
		
		Player find = playerReposit.findByUsernameAndPassword(login.getUsername(), login.getPassword());
		if( Objects.nonNull(find) ) {
			session.setAttribute("id", find.getId());
		}
	}
	
}
