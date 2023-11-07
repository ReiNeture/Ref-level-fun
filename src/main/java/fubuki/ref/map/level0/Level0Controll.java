package fubuki.ref.map.level0;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fubuki.ref.monster.Monster;
import fubuki.ref.monster.Rabbit;

@Controller
@RequestMapping("/map/level0")
public class Level0Controll {

    @GetMapping("/mori")
    public String mapMori() {
        return "map/mori";
    }
    
    @GetMapping("/sea")
    public String mapSea(Model model) {
    	
    	List<Monster> Monsters = Arrays.asList(new Rabbit(), new Rabbit(), new Rabbit());
    	model.addAttribute("monsters", Monsters);
    	
        return "map/sea";
    }
	
}
