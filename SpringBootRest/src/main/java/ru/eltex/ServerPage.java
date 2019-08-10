package ru.eltex;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.eltex.entity.User;

@Controller
public class ServerPage {
    @RequestMapping("/fd")
    public String index(Model model) throws JsonProcessingException {
        model.addAttribute("AllUsers",Hibernate.getAllUserData() );
        return "index";
    }
}

