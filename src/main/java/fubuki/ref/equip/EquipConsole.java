package fubuki.ref.equip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/equip")
public class EquipConsole {

	@Autowired
	EquipService equipService;
	
    @GetMapping("/create")
    public String createAnEquipPage(Model model) {
    	
    	model.addAttribute("equip", new Equip());
    	
        return "equip/create";
    }
	
    @PostMapping("/create")
    public String createAnEquip(@Valid Equip data, Errors errors) {
    	
    	if(errors.hasErrors() ) {
            return "equip/create";
        }
    	
    	equipService.createEquip(data);
    	
        return "redirect:equip/create";
    }
}
