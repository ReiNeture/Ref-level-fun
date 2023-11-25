package fubuki.ref.map.level1;

import static fubuki.ref.monster.MonsterInstanceFactory.getMonsterByClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fubuki.ref.monster.DesertCrocodile;
import fubuki.ref.monster.DesertRat;
import fubuki.ref.monster.Monster;

@Controller
@RequestMapping("/map/level1")
public class Level1Controll {

	Random rand = new Random();
	
    @GetMapping("/abundant")
    public String mapAbundant() {
    	
        return "map/level1/abundant";
    }

    
    @GetMapping("/arabianDesert")
    public String mapDesert(Model model) {
    	
    	List<Monster> Monsters = new ArrayList<>();
    	Monsters.add(getMonsterByClass(DesertRat.class) );
    	
    	if( rand.nextInt(100) == 49 ) {
    		Monsters.add(getMonsterByClass(DesertCrocodile.class) );
    	}
    	
    	model.addAttribute("monsters", Monsters);
        return "map/level1/desert";
    }
    
    @GetMapping("/temple")
    public String mapTemple(Model model) {
    	
    	return "map/level1/temple";
    }
	
}