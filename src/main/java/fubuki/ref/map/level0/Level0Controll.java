package fubuki.ref.map.level0;

import static fubuki.ref.monster.MonsterInstanceFactory.getMonsterByClass;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fubuki.ref.monster.DarkRabbit;
import fubuki.ref.monster.Monster;
import fubuki.ref.monster.Rabbit;

@Controller
@RequestMapping("/map/level0")
public class Level0Controll {

    @GetMapping("/mori")
    public String mapMori() {
        return "map/level0/mori";
    }
    
    @GetMapping("/shop")
    public String mapShop() {
        return "map/level0/shop";
    }
    
    @GetMapping("/sea")
    public String mapSea(Model model) {
    	
    	List<Monster> Monsters = Arrays.asList(
			    			getMonsterByClass(Rabbit.class),
			    			getMonsterByClass(Rabbit.class),
			    			getMonsterByClass(Rabbit.class),
			    			getMonsterByClass(DarkRabbit.class));
    	
    	model.addAttribute("monsters", Monsters);
    	
        return "map/level0/sea";
    }
	
}
