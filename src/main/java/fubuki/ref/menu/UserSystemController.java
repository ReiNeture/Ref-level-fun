package fubuki.ref.menu;

import java.util.Objects;

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
	
	// 註冊頁面
    @GetMapping("/signin")
    public String signinPage(Model model) {
    	model.addAttribute("player", new Player());
        return "user/signin";
    }
    
    // 進行註冊
    @PostMapping("/signin")
    public String signinUser(@Valid Player data, Errors errors) {
    	
    	if (errors.hasErrors()) {
            return "user/signin";
        }
    	
		playerService.initPlayer(data);
		
	    return "redirect:/user/login";
        
    }
    
    
    // 登入頁面
    @GetMapping("/login")
    public String loginPage(Model model) {
    	model.addAttribute("player", new Player());
        return "user/login";
    }
    
    // 進行登入
    @PostMapping("/login")
    public String loginUser(Player login, HttpSession session) {
    	
    	Player find = playerService.loginPlayer(login);
    	if( Objects.nonNull(find) ) {
			session.setAttribute("id", find.getId());
			return "redirect:/main/home";
			
		} else {
			return "redirect:/user/login";
		}
        
    }
    
    // 登出
    @GetMapping("/logout")
    public String logoutUser(HttpSession session) {
    	session.invalidate();
        return "redirect:/user/login";
    }
	
}
