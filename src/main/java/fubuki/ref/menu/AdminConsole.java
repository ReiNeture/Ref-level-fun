package fubuki.ref.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fubuki.ref.dao.entity.Monster;
import fubuki.ref.model.MonsterManager;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/console")
public class AdminConsole {

	@Autowired
	MonsterManager monsterManager;
	
    @GetMapping("/monster")
    public String monsterManager(Model model) {
    	model.addAttribute("monster", new Monster());
        return "console/monster";
    }
	
    @PostMapping("/monster")
    public String addMonster(Model model, @Valid Monster data, Errors errors) {
    	
    	if( !errors.hasErrors() ) {
    		monsterManager.createMonster(data);
        	model.addAttribute("monster", new Monster());
        	model.addAttribute("success", true);
    	}
    	
        return "console/monster";
    }
	
}
