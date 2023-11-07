package fubuki.ref.combat;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fubuki.ref.character.CharacterService;
import fubuki.ref.model.PlayerService;
import fubuki.ref.monster.Monster;
import fubuki.ref.monster.MonsterInstanceFactory;
import fubuki.ref.monster.Noname;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/combat")
public class CombatController {

	@Autowired
	PlayerService playService;
	@Autowired
	CombatService combatService;
	@Autowired
	CharacterService characterService;

	@GetMapping("/{name}")
	public String combatToMonster(@PathVariable String name, HttpSession session) {

		playService.isLogined(session);

		long id = (long) session.getAttribute("id");
		Optional<Combat> combat = combatService.getCombatInfo(id);

		if(combat.isEmpty() )
			combatService.combatToMonster(id, name);

		return "redirect:/combat";
	}

	@GetMapping("")
	public String getCombatInfo(Model model, HttpSession session) {

		playService.isLogined(session);

		long id = (long) session.getAttribute("id");
		Optional<Combat> combat = combatService.getCombatInfo(id);

		if (combat.isPresent()) {
			Combat value = combat.get();
			model.addAttribute("combat", value);
			model.addAttribute("monster", MonsterInstanceFactory.getMonsterByName(value.getMonsterName()));
		} else {
			model.addAttribute("combat", new Combat());
			model.addAttribute("monster", new Noname());
		}

		return "combat/combat";
	}

	@PostMapping("/finish")
	public String finishCombat(Model model, HttpSession session) {

		playService.isLogined(session);

		long id = (long) session.getAttribute("id");
		Optional<Combat> combat = combatService.getCombatInfo(id);

		if (combat.isPresent()) {
			
			Combat value = combat.get();
			Monster monster = MonsterInstanceFactory.getMonsterByName(value.getMonsterName());
			
			combatService.applyCombat(value);
			
			model.addAttribute("combat", value);
			model.addAttribute("monster", monster);
			model.addAttribute("getExp", monster.getExp());
			model.addAttribute("getCoin", monster.getCoin());
			
		} else {
			throw new IllegalStateException("not have combat");
		}

		return "combat/finish";
	}
}
