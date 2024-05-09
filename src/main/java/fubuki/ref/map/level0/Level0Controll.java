package fubuki.ref.map.level0;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fubuki.ref.equip.Equip;
import fubuki.ref.monster.Monster;

@Controller
@RequestMapping("/map/level0")
public class Level0Controll {

	@Autowired
	ShoppingStreet shoppingStreetService;
	@Autowired
	SeaExploreArea SeaExploreService;
	
	
    @GetMapping("/mori")
    public String mapMori() {
        return "map/level0/mori";
    }
    
    @GetMapping("/shop")
    public String mapShop(Model model) {
    	List<Equip> equipList = shoppingStreetService.getShoppingStreetGoods();
    	model.addAttribute("equips", equipList);
    	
        return "map/level0/shop";
    }
    
    @GetMapping("/sea")
    public String mapSea(Model model) {
    	List<Monster> Monsters = SeaExploreService.getSeaMonsters();
    	model.addAttribute("monsters", Monsters);
    	
        return "map/level0/sea";
    }
	
}
