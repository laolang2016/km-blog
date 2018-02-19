package com.laolang.kmblog.web;

import com.github.pagehelper.PageInfo;
import com.laolang.kmblog.domain.Inbox;
import com.laolang.kmblog.domain.UserBase;
import com.laolang.kmblog.service.InboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@RequestMapping("u")
@Controller
public class InboxController {

    @Autowired
    private InboxService inboxService;

    @RequestMapping(value = "{blogUrl}/admin/inbox",method = RequestMethod.GET)
    public String inboxList(Model model , HttpSession session,@RequestParam(value = "type",defaultValue = "all") String type,
                            @RequestParam(value = "page",defaultValue = "1") int page ,
                            @RequestParam(value = "size",defaultValue = "10") int size){
        UserBase currentUserBase = getCurrentUserBase(session);
        if( null == currentUserBase ){
            return "redirect:/index";
        }






        return "u/inbox";

    }

    private UserBase getCurrentUserBase( HttpSession session){
        return (UserBase) session.getAttribute("userBase");
    }
}
