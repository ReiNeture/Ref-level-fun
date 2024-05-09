package fubuki.ref.equip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fubuki.ref.util.UserStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/equip")
public class EquipConsole {

	@Autowired
	EquipService equipService;
	
    @PostMapping("/buy")
    public String buyShop(@RequestParam String buy, HttpServletRequest request, HttpSession session) {
    	
    	UserStatus.isLogined(session);

		long pid = (long) session.getAttribute("id");
    	
    	equipService.buyAnEquip(buy, pid);
    	
        return "map/level0/shop";
    }
    
}
