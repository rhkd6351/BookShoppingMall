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
public class UserController {

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

    @PostMapping("/login") //http://localhost:8080/user/login?email=ls&pw=hjh
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
                return "redirect:/user/myPage";
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
        log.info(userProperty);
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
        return "redirect:/user/myPage";
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

    @GetMapping("/myPage")
    public String login(Model model){
        //로그인 확인처리는 intercepture 에서 진행
        UserVO vo = (UserVO) session.getAttribute("user");
        model.addAttribute("user", vo);
        return "/myPage";
    }

    @GetMapping("/changePw")
    public String changePw(){
        return "/user_manage/pwCert";
    }
    @GetMapping("/changeBirth")
    public String changeBirth(){
        return "/user_manage/birthChange";
    }
    @GetMapping("/changeGender")
    public String changeGender(){
        return "/user_manage/genderChange";
    }
    @GetMapping("/changePhone")
    public String changePhone(){
        return "/user_manage/phoneChange";
    }

    @PostMapping("/pwCert")
    public String pwCert(@RequestParam String pw, Model model){
        UserVO vo = (UserVO) session.getAttribute("user");
        if(pw.equals(vo.getPw())){
            return "/user_manage/pwChange";
        }else{
            model.addAttribute("certify", "false");
            return "/user_manage/pwCert";
        }
    }
    @ResponseBody
    @PostMapping("/pwChange")
    public String pwChange(@RequestParam String pw){
        String[] pwList = pw.split(",");
        UserVO vo = (UserVO) session.getAttribute("user");
        vo.setPw(pw);
        session.setAttribute("user",vo);
        userService.updatePw(pwList[0], vo.getEmail());
        return "<script>alert('change success'); location.href='/user/myPage';</script>";
    }

    @ResponseBody
    @PostMapping("/genderChange")
    public String genderChange(@RequestParam String gender){
        UserVO vo = (UserVO) session.getAttribute("user");
        userService.updateGender(gender, vo.getEmail());
        vo.setGender(gender);
        session.setAttribute("user",vo);
        return "<script>alert('change success'); location.href='/user/myPage';</script>";
    }

    @ResponseBody
    @PostMapping("/birthChange")
    public String birthChange(@RequestParam String birth){
        UserVO vo = (UserVO) session.getAttribute("user");
        userService.updateBirth(birth, vo.getEmail());
        vo.setBirth(birth);
        session.setAttribute("user",vo);
        return "<script>alert('change success'); location.href='/user/myPage';</script>";
    }

    @ResponseBody
    @PostMapping("/phoneChange")
    public String phoneChange(@RequestParam String phone){
        UserVO vo = (UserVO) session.getAttribute("user");
        userService.updatePhone(phone, vo.getEmail());
        vo.setPhone(phone);
        session.setAttribute("user",vo);
        return "<script>alert('change success'); location.href='/user/myPage';</script>";
    }

}
