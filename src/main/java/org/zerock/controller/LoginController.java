package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.TokenVO;
import org.zerock.domain.UserVO;
import org.zerock.service.KakaoService;
import org.zerock.service.TokenService;
import org.zerock.service.UserService;
import sun.misc.Request;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("/user")
public class LoginController {

    UserService userService;
    HttpSession session;
    KakaoService kakaoService;
    TokenService tokenService;


    @GetMapping("/login")
    public String login(Model model, String loginTry, String loginMsg){ // send message to login page
        if(loginTry == null)
            return "/login";
        if(loginTry.equals("false")){
            model.addAttribute("loginTry", false);
            model.addAttribute("loginMsg",loginMsg);
        }else{
            model.addAttribute("loginTry", true);
        }
        return "/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String pw, RedirectAttributes rttr){
        log.info("second called");
        UserVO vo = userService.get(email);
        if(vo == null){ // 아이디 없음
            rttr.addFlashAttribute("loginTry","false");
            rttr.addFlashAttribute("loginMsg","존재하지 않는 아이디입니다.");
            return "redirect:/user/login";
        }else{
            if(!vo.getPw().equals(pw)){ // 비밀번호 불일치
                rttr.addFlashAttribute("loginTry","false");
                rttr.addFlashAttribute("loginMsg","잘못된 비밀번호입니다.");
                return "redirect:/user/login";
            }else{ //로그인 성공
                session.setAttribute("user", vo);
                rttr.addFlashAttribute("loginTry","true");
                return "/index";
            }
        }
    }
    @GetMapping("/logout")
    public String logout(){
        session.removeAttribute("user");
        return "/login";
    }

    @RequestMapping("/login/kakao")
    public String getKakaoLogin(@RequestParam(value = "code", required = false) String code,
                                RedirectAttributes rttr,
                                HttpServletRequest request,
                                HttpServletResponse response){

        HashMap<String, String> tokenMap = null;
        HashMap<String,String> userProperty = null;
        TokenVO refreshToken = null;
        String accessToken = null;

        //쿠키에 refresh 코드가 있다면 refresh code로 access코드 요청
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if("refresh".equals(cookie.getName())){
                log.info(cookie.getName());
                log.info(cookie.getValue());
                refreshToken = tokenService.get(Integer.parseInt(cookie.getValue()));
                //TODO 토큰 유효기간 확인 넣어야함
                accessToken = kakaoService.getAccessCode(refreshToken);
            }
        }

        //refresh 토큰이 없는경우 authorization code로 토큰 요청
        if(accessToken == null){
            tokenMap = kakaoService.getAccessCode(code);
            accessToken = tokenMap.get("accessToken");

            //쿠키에 refresh cookie index 추가
            refreshToken = new TokenVO();
            refreshToken.setRefreshToken(tokenMap.get("refreshToken"));
            refreshToken.setRefreshDuration(tokenMap.get("refreshTokenExpiresIn"));
            tokenService.insertSelectKey(refreshToken);

            Cookie refreshCookie = new Cookie("refresh",Integer.toString(refreshToken.getOid()));
            response.addCookie(refreshCookie);
        }

        //property 요청
        userProperty = kakaoService.getProperty(accessToken);

        UserVO vo = userService.get(userProperty.get("email"));
        if(vo == null){ // 계정이 없으면 생성
            vo = new UserVO();
            vo.setEmail(userProperty.get("email"));
            vo.setBirth(userProperty.get("birth"));
            vo.setGender(userProperty.get("gender"));
            vo.setPlatform("kakao");
            userService.kakaoInsert(vo);
        }

        if(!vo.getPlatform().equals("kakao")){ // 카카오계정이 이미 로컬계정으로 존재하는경우
            rttr.addFlashAttribute("loginTry","false");
            rttr.addFlashAttribute("loginMsg","이미 존재하는 이메일로 가입된 계정이 있습니다.");
            return "redirect:/user/login";
        }
        vo = userService.get(userProperty.get("email"));

        session.setAttribute("user",vo);
        return "/index";
    }


    @GetMapping("/register")
    public String localRegister(){
        return "/register";
    }

    @ResponseBody
    @PostMapping("/register")
    public String register(UserVO vo, Model model){

        userService.insert(vo);
        return "<script>alert('register success!'); location.href='/user/login';</script>";
    }

    @ResponseBody
    @GetMapping("/emailValidCheck")
    public String emailValidCheck(@RequestParam String email){
        log.info(email);
        UserVO vo = userService.get(email);
        if(vo != null){
            log.info("wow");
            return "true";
        }else{
            log.info("wow2");
            return "false";
        }
    }
}
