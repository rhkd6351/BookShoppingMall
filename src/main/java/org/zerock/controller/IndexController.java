package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.service.ProductService;


/**
 * Handles requests for the application home page.
 */
@Controller
@AllArgsConstructor
@Log4j
public class IndexController {

    ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("newBookLayer",productService.getNewBookLayer(4));
        return "/main";
    }
}
