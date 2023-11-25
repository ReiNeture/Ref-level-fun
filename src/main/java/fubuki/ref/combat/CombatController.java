package fubuki.ref.combat;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fubuki.ref.character.CharacterService;
import fubuki.ref.monster.Monster;
import fubuki.ref.monster.MonsterInstanceFactory;
import fubuki.ref.player.PlayerService;
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
	public String combatToMonster(@PathVariable String name, RedirectAttributes redirAttrs, HttpSession session) {

		playService.isLogined(session);

		long pid = (long) session.getAttribute("id");

		if( characterService.isBusy(pid) ) {
			redirAttrs.addFlashAttribute("flash", "有戰鬥未結算");
			
		} else {
			combatService.combatToMonster(pid, name);
			redirAttrs.addFlashAttribute("flash", "新增了一個戰鬥");
		}
		
		return "redirect:/combat";
	}

	@GetMapping
	public String getCombatInfo(Model model, HttpSession session) {

		playService.isLogined(session);

		long pid = (long) session.getAttribute("id");
		Optional<Combat> combat = combatService.getCharacterCombat(pid);

		if (combat.isPresent()) {
			Combat value = combat.get();
			model.addAttribute("combat", value);
			model.addAttribute("monster", MonsterInstanceFactory.getMonsterByName(value.getMonsterName()));
			
		} else {
			model.addAttribute("combat", new Combat());
//			model.addAttribute("monster", new Noname());
		}

		return "combat/combat";
	}

	@PostMapping("/finish")
	public String finishCombat(@RequestParam long id, Model model, HttpSession session) {

		playService.isLogined(session);

		Optional<Combat> combat = combatService.getCombatInfo(id);

		if( combat.isEmpty() )
			throw new IllegalStateException("not have combat");
		
		Combat value = combat.get();
		
		if( LocalDateTime.now().isBefore(value.getEndTime() ) )
			throw new IllegalStateException("can't finish combat");
		
		Monster monster = MonsterInstanceFactory.getMonsterByName(value.getMonsterName());
		combatService.applyCombat(value);
			
		model.addAttribute("combat", value);
		model.addAttribute("monster", monster);
		model.addAttribute("getExp", monster.getExp());
		model.addAttribute("getCoin", monster.getCoin());

		return "combat/finish";
	}
}
