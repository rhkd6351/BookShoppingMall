package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("/")
public class MainController {

    UserService userService;
    HttpSession session;

    public boolean login(){
        if(session.getAttribute("user") == null)
            return false;
        else
            return true;
    }

    @GetMapping("/myInfo")
    public String myInfo(){
        if(login()){
            return "/login";
        }

        return "/myInfo";
    }
}
