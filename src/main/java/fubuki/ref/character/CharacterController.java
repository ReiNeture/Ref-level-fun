package fubuki.ref.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fubuki.ref.player.PlayerService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/chars")
public class CharacterController {

	@Autowired
	CharacterService characterService;
	@Autowired
	PlayerService playService;
	
	
	@GetMapping
	public String getCharsInfo(Model model, HttpSession session) {
		
		playService.isLogined(session);
		long pid = (long) session.getAttribute("id");
		Characters chars = characterService.getCharacterData(pid);
		
		model.addAttribute("character", chars);
		
		return "characters/character";
	}
}
