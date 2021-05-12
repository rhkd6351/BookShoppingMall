package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.ImagePubVO;
import org.zerock.domain.PubVO;
import org.zerock.domain.UserVO;
import org.zerock.service.*;

import javax.servlet.http.HttpSession;

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

    @PostMapping("/register")
    public String pubRegister(@Param("pub_name") String pub_name, @Param("pub_desc") String pub_desc, @Param("pub_img") MultipartFile pub_img,
                              Model model){
        UserVO userVo = (UserVO) session.getAttribute("user");

        PubVO pubVO = new PubVO(pub_name,pub_desc, userVo.getEmail());
//        pubVO.setName(pub_name);
//        pubVO.setDescription(pub_desc);
//        pubVO.setUserEmail(userVo.getEmail());
        pubService.insert(pubVO);

        ImagePubVO imagePubVO = fileUploadService.pubImageUpload(pub_img, pub_name);
        imagePubVO.setPubOid(pubVO.getOid());
        imageService.insertPubImage(imagePubVO);

        model.addAttribute("message", "출판사 등록에 성공하였습니다.");
        return "redirect:/pub/sendMessage";
    }

    @PostMapping("/modify")
    public String pubModify(@RequestParam(value = "img", required= false) MultipartFile img,
                            @RequestParam("description") String description,
                            @RequestParam("oid") int oid,
                            Model model){
        PubVO pubVO = pubService.get(oid);
        pubVO.setDescription(description);
        if(img != null){
           ImagePubVO imagePubVO = fileUploadService.pubImageUpload(img,pubVO.getName());
           //파일명을 이름기반으로 저장하니 db업데이트는 필요없음
            //TODO 수정 필요
        }
        pubService.update(pubVO);

        model.addAttribute("message","수정에 성공하였습니다.");
        return "redirect:/pub/sendMessage";
    }

    @GetMapping("/manage")
    public String pubManage(Model model){
        UserVO userVo = (UserVO) session.getAttribute("user");
        PubVO pubVO = pubService.get(userVo.getEmail());

        if(pubVO == null){ //출판사 등록여부 확인
            model.addAttribute("message", "출판사 등록 후 관리가 가능합니다.");
            return "redirect:/product/sendMessage";
        }

        model.addAttribute("pub",pubVO);
        model.addAttribute("pubImage", imageService.getPubImage(pubVO.getOid()));
        return "/pub_manage/pub_manage";
    }

    @GetMapping("/delete")
    public String pubDelete(Model model){
        UserVO userVO = (UserVO) session.getAttribute("user");
        try{
            pubService.delete(userVO.getEmail());
        }catch(Exception e){
            model.addAttribute("message", "오류가 발생하였습니다.");
            return "redirect:/pub/sendMessage";
        }
        model.addAttribute("message", "삭제되었습니다.");
        return "redirect:/pub/sendMessage";
    }
}
