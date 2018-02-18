package com.laolang.kmblog.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("u")
@Controller
public class UserAdminController {

    private static final Logger log = LoggerFactory.getLogger(UserAdminController.class);

    @RequestMapping(value = "{blogUrl}/admin",method = RequestMethod.GET)
    public String index(Model model,@PathVariable String blogUrl){
        model.addAttribute("info","user setting");
        return "u/index";
    }

}
