package com.laolang.kmblog.web;

import com.laolang.kmblog.domain.UserBase;
import com.laolang.kmblog.exception.KmblogServiceNotFoundException;
import com.laolang.kmblog.service.UserBaseService;
import com.laolang.kmblog.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserBaseService userBaseService;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String loginForm(){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(Model model , UserBase userBase , HttpSession session){
        String page = "redirect:/index";
        UserBase user = null;
        try{
            if(StringUtil.isNotEmpty(userBase.getPhone())){
                user = userBaseService.findByPhone(userBase.getPhone());
            }else if (StringUtil.isNotEmpty(userBase.getEmail())){
                user = userBaseService.findByEmail(userBase.getEmail());
            }
            if( null != user ){
                session.setAttribute("userBase",user);
            }
        }catch (KmblogServiceNotFoundException e){
            log.error(e.getMessage());
            model.addAttribute("error","用户名或密码错误");
            page = "error";
        }

        return page;
    }
}
