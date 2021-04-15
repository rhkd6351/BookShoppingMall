package org.zerock.intercepture;

import lombok.extern.log4j.Log4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j
public class LoginIntercepture implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object obj) throws Exception{
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            response.sendRedirect("/user/login");
            return false;
        }else{
            return true;
        }



    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object obj, ModelAndView mav) throws Exception {


    }

    // view까지 처리가 끝난 후에 처리됨
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object obj, Exception e) throws Exception {

    }



}
