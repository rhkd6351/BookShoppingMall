package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("/login")
public class LoginController {

    UserService userService;
    HttpSession session;

    @PostMapping("/")
    public String login(String email, String pw, Model model){
        UserVO vo = userService.get(email);
        if(vo == null){ // 아이디 없음
            model.addAttribute("loginTry",false);
            return "/login";
        }else{
            if(!vo.getPw().equals(pw)){ // 비밀번호 불일치
                model.addAttribute("loginTry",false);
                return "/login";
            }else{ //로그인 성공
                session.setAttribute("user", vo);
                model.addAttribute("loginTry",true);
                return "/main";
            }
        }
    }
}
