package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.*;
import org.zerock.service.*;

import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("/product")
public class ProductController {

    PubService pubService;
    AuthorService authorService;
    CategoryService categoryService;
    ProductService productService;
    FileUploadService fileUploadService;
    ImageService imageService;
    HttpSession session;

    @ResponseBody
    @GetMapping(value = "/sendMessage", produces = "text/html; charset=utf8")
    public String sendMessage(String message){
        return "<script>alert('" + message + "');location.href='/user/myPage'</script>";
    }

    @GetMapping("/modify")
    public String productModify(Model model, @RequestParam("oid") int oid){
        UserVO userVo = (UserVO) session.getAttribute("user");

        //Todo 열람하는 상품이 세션 계정소유인지 확인하고 리다이렉트

        model.addAttribute("pub",pubService.get(userVo.getEmail())); //pub정보 전송
        model.addAttribute("author",authorService.getAll()); //author 정보 전송
        model.addAttribute("category",categoryService.getAll()); //category 정보 전송
        model.addAttribute("product", productService.get(oid));

        return "/product_manage/product_modify";
    }

    @PostMapping("/modify")
    public String productModify(@RequestParam("title") String title, @RequestParam("subTitle") String subTitle,
                                @RequestParam("pub") int pub, @RequestParam("price") int price, @RequestParam("deliveryFee") int deliveryFee,
                                @RequestParam("description") String description, @RequestParam("contents") String contents,
                                @RequestParam(value= "author", required=false) int author, @RequestParam("category") int category,
                                @RequestParam(value = "mainImage", required = false) MultipartFile mainImage,
                                @RequestParam(value = "descriptionImage", required = false) MultipartFile descriptionImage,
                                @RequestParam("oid") int oid,
                                @RequestParam(value = "author_name", required=false) String author_name, @RequestParam(value = "author_description", required=false) String author_description,
                                Model model){

        if(author_name != null){ //저자 직접입력시 db입력 후 oid 반환
            AuthorVO authorVO = new AuthorVO();
            authorVO.setName(author_name); authorVO.setDescription(author_description);
            authorService.insert(authorVO);
            author = authorVO.getOid();
        }
        ProductVO productVO = productService.init(title, subTitle, pub, price, contents, deliveryFee, description,author,
                category); //생성자 대용(VO를 @Data등록하고 생성자 메소드 생성시 오류발생하여 서비스에서 기능대체)
        productVO.setOid(oid);
        productService.update(productVO);


        if(mainImage != null){
            fileUploadService.productImageUpload(mainImage,title,"represent");
            //파일명을 이름기반으로 저장하니 db업데이트는 필요없음
            //TODO 수정 필요
        }
        if(descriptionImage != null){
            fileUploadService.productImageUpload(descriptionImage,title,"description");
            //파일명을 이름기반으로 저장하니 db업데이트는 필요없음
            //TODO 수정 필요
        }

        model.addAttribute("message","수정에 성공하였습니다.");
        return "redirect:/product/sendMessage";
    }

    @GetMapping("/register")
    public String productRegister(Model model){
        UserVO userVo = (UserVO) session.getAttribute("user");

        if(pubService.get(userVo.getEmail()) == null){ //출판사 등록여부 확인
            model.addAttribute("message", "출판사 등록 후 상품등록이 가능합니다.");
            return "redirect:/product/sendMessage";
        }

        model.addAttribute("pub",pubService.get(userVo.getEmail())); //pub정보 전송
        model.addAttribute("author",authorService.getAll()); //author 정보 전송
        model.addAttribute("category",categoryService.getAll()); //category 정보 전송

        return "/product_manage/product_register";
    }

    @PostMapping("register")
    public String productRegister(@RequestParam("title") String title, @RequestParam("subTitle") String subTitle,
                                  @RequestParam("pub") int pub, @RequestParam("price") int price, @RequestParam("deliveryFee") int deliveryFee,
                                  @RequestParam("description") String description, @RequestParam("contents") String contents,
                                  @RequestParam(value= "author", required=false) int author, @RequestParam("category") int category,
                                  @RequestParam("mainImage") MultipartFile mainImage,
                                  @RequestParam("descriptionImage") MultipartFile descriptionImage,

                                  @RequestParam(value = "author_name", required=false) String author_name, @RequestParam(value = "author_description", required=false) String author_description,
                                  Model model){

        if(author_name != null){ //저자 직접입력시 db입력 후 oid 반환
            AuthorVO authorVO = new AuthorVO();
            authorVO.setName(author_name); authorVO.setDescription(author_description);
            authorService.insert(authorVO);
            author = authorVO.getOid();
        }
        ProductVO productVO = productService.init(title, subTitle, pub, price, contents, deliveryFee, description,author,
                                        category); //생성자 대용(VO를 @Data등록하고 생성자 메소드 생성시 오류발생하여 서비스에서 기능대체)
        productService.insert(productVO);

        ImageProductVO vo1 = fileUploadService.productImageUpload(mainImage, title, "represent");
        vo1.setProductOid(productVO.getOid());
        imageService.insertProductImage(vo1);

        ImageProductVO vo2 = fileUploadService.productImageUpload(descriptionImage, title, "description");
        vo2.setProductOid(productVO.getOid());
        imageService.insertProductImage(vo2);

        model.addAttribute("message", "상품등록에 성공하였습니다.");
        return "redirect:/product/sendMessage";
    }

    @GetMapping("/manage")
    public String productManage(Model model){
        UserVO userVO = (UserVO) session.getAttribute("user");
        PubVO pubVO = pubService.get(userVO.getEmail());

        model.addAttribute("pub", pubVO);
        model.addAttribute("products", productService.getAccordingToPubOid(pubVO.getOid()));

        return "/product_manage/product_manage";
    }


    @GetMapping("/view")
    public String productView(@RequestParam("oid") int oid, Model model){
        model.addAttribute("product",productService.getSpecProduct(oid));
        return "/product/product";
    }
}
