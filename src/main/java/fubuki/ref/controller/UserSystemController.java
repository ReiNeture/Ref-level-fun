package fubuki.ref.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fubuki.ref.dao.entity.Player;
import fubuki.ref.model.PlayerService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserSystemController {

	@Autowired
	PlayerService playerService;
	
    @GetMapping("/signin")
    public String signinPage(Model model) {
    	model.addAttribute("player", new Player());
        return "user/signin";
    }
    
    @PostMapping("/signin")
    public String signinUser(@Valid Player data, Errors errors) {
    	
    	if (errors.hasErrors()) {
            return "user/signin";
        }
    	
		playerService.siginPlayer(data);
	    return "user/login";
        
    }
    
    @GetMapping("/login")
    public String loginPage(Model model) {
    	model.addAttribute("player", new Player());
        return "user/login";
    }
    
    @PostMapping("/login")
    public String loginUser(Player login, HttpSession session) {
    	playerService.loginPlayer(login, session);
        return "main/home";
    }
	
}
