package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ImagePubVO;
import org.zerock.domain.PubVO;
import org.zerock.domain.TokenVO;
import org.zerock.domain.UserVO;
import org.zerock.service.*;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("/pub")
public class PubController {

    UserService userService;
    PubService pubService;
    ImageService imageService;
    HttpSession session;
    FileUploadService fileUploadService;

    //TODO ajax 출판사 이름 중복검사

    @ResponseBody
    @GetMapping(value = "/sendMessage", produces = "text/html; charset=utf8")
    public String sendMessage(String message){
        return "<script>alert('" + message + "');location.href='/user/myPage'</script>";
    }

    @GetMapping("/register")
    public String pubRegister(Model model){
        UserVO userVo = (UserVO) session.getAttribute("user");
        if(pubService.get(userVo.getEmail()) != null){ //1인당 1개 출판사등록 제한
            model.addAttribute("message", "최대 한개의 출판사만 등록 가능합니다.");
            return "redirect:/pub/sendMessage";
        }

        return "/pub_manage/pub_register";
    }

    @ResponseBody
    @PostMapping("/register")
    public String pubRegister(@Param("pub_name") String pub_name, @Param("pub_desc") String pub_desc, @Param("pub_img") MultipartFile pub_img,
                              Model model){
        UserVO userVo = (UserVO) session.getAttribute("user");

        PubVO pubVO = new PubVO();
        pubVO.setName(pub_name);
        pubVO.setDescription(pub_desc);
        pubVO.setUserEmail(userVo.getEmail());
        pubService.insert(pubVO);

        ImagePubVO imagePubVO = fileUploadService.pubImageUpload(pub_img, pub_name);
        imagePubVO.setPubOid(pubVO.getOid());
        imageService.insertPubImage(imagePubVO);

        model.addAttribute("message", "출판사 등록에 성공하였습니다.");
        return "redirect:/pub/sendMessage";
    }

}
