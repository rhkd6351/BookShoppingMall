package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zerock.domain.CartVO;
import org.zerock.domain.UserVO;
import org.zerock.dto.CartViewDTO;
import org.zerock.service.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("/order")
public class OrderController {

    HttpSession session;
    CartService cartService;

    @ResponseBody
    @GetMapping(value = "/sendMessage", produces = "text/html; charset=utf8")
    public String sendMessage(String message){
        return "<script>alert('" + message + "');location.href='/user/myPage'</script>";
    }

    @PostMapping(value = "/", params = {"productOid", "quantity"})
    public String order(Model model,@RequestParam(value = "productOid") int productOid, @RequestParam(value = "quantity") int quantity){
        UserVO userVO = (UserVO)session.getAttribute("user");
        CartVO cartVO = new CartVO(productOid,quantity, userVO.getEmail());
        cartService.insert(cartVO);

        CartViewDTO cartViewDTO = cartService.getByOid(cartVO.getOid());
        ArrayList<CartViewDTO> cartList = new ArrayList<>();
        cartList.add(cartViewDTO);

        model.addAttribute("cartList",cartList);
        cartService.delete(cartVO.getOid(),userVO.getEmail());
        return "/order/order";
    }

    @PostMapping(value = "/", params = {"cartOid"})
    public String order(Model model,@RequestParam(value = "cartOid") ArrayList<Integer> cartOidList){
        UserVO userVO = (UserVO)session.getAttribute("user");
        ArrayList<CartViewDTO> cartList = new ArrayList<>();
        for(int a : cartOidList){
            cartList.add(cartService.getByOid(a));
        }
        model.addAttribute("cartList",cartList);
        return "/order/order";
    }
}