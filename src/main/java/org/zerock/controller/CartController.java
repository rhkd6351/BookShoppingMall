package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.CartVO;
import org.zerock.domain.UserVO;
import org.zerock.dto.CartViewDTO;
import org.zerock.service.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("/cart")
public class CartController {

    CartService cartService;
    HttpSession session;

    @ResponseBody
    @GetMapping(value = "/sendMessage", produces = "text/html; charset=utf8")
    public String sendMessage(String message){
        return "<script>alert('" + message + "');history.back();</script>";
    }

//  post
    @GetMapping(value = "/post", params = {"productOid", "quantity"})
    public String cartPost(Model model , @RequestParam(value = "productOid") int productOid,
                           @RequestParam(value = "quantity") int quantity){
        UserVO userVO = (UserVO)session.getAttribute("user");
        CartVO cartVO = new CartVO(productOid,quantity, userVO.getEmail());
        cartService.insert(cartVO);

        model.addAttribute("message","장바구니에 성공적으로 담겼습니다.");
        return "redirect:/cart/sendMessage";
    }

    @GetMapping(value = "/")
    public String cartList(Model model){
        UserVO userVO = (UserVO)session.getAttribute("user");
        ArrayList<CartViewDTO> cartList = cartService.getByUserEmail(userVO.getEmail());
        model.addAttribute("cartList", cartList);
        return "/product/cart";
    }

    @GetMapping("/delete")
    public String cartDelete(@Param("cartOid") int cartOid){
        UserVO userVO = (UserVO)session.getAttribute("user");
        cartService.delete(cartOid, userVO.getEmail());
        return "redirect:/cart/";
    }
}
