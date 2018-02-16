package com.laolang.kmblog.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);


    /**
     * 首页
     * @return
     */
    @RequestMapping(value = {"/","index"})
    public String index(Model model){
        log.info("index");
        model.addAttribute("info","km blog ssm!");
        return "index";
    }
}
