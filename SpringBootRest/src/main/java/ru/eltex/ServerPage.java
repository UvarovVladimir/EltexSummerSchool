package ru.eltex;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServerPage {
    @RequestMapping("/index")
    public String index(Model model) throws JsonProcessingException {
        model.addAttribute("AllUsers",Hibernate.getAllUserData() );
        return "index";
    }

    @RequestMapping("/admin")
    public String indexAdmin(Model model) throws JsonProcessingException {
        model.addAttribute("AllUsers",Hibernate.getAllUserData() );
        return "indexAdmin";
    }

}

