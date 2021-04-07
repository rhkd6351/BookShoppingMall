package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
@AllArgsConstructor
@Log4j
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "/index";
    }
}
