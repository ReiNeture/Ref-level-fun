package fubuki.ref.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainMenuController {

    @GetMapping("/home")
    public String homePage() {
        return "main/home";
    }
    
    
    @GetMapping("/world")
    public String worldPage() {
        return "main/world";
    }
}
