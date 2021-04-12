package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;
import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("/user")
public class UserController {

    UserService userService;
    HttpSession session;


    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("loginTry", true);
        return "/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String pw, Model model){
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
                return "/index";
            }
        }
    }
    @GetMapping("/logout")
    public String logout(){
        session.removeAttribute("user");
        return "/login";
    }


    @GetMapping("/register")
    public String register(){
        return "/register";
    }

    @ResponseBody
    @PostMapping("/register")
    public String register(UserVO vo, Model model){

        userService.insert(vo);
        return "<script>alert('register success!'); location.href='/user/login';</script>";
    }
}
