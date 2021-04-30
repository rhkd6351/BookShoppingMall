package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zerock.service.*;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("/order")
public class OrderController {

    HttpSession session;

    @ResponseBody
    @GetMapping(value = "/sendMessage", produces = "text/html; charset=utf8")
    public String sendMessage(String message){
        return "<script>alert('" + message + "');location.href='/user/myPage'</script>";
    }

}