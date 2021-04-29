package org.zerock.intercepture;

import lombok.extern.log4j.Log4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.dto.ProductRecentDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Log4j
public class RecentBookIntercepture implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object obj) throws Exception{
        HttpSession session = request.getSession();
        if(session.getAttribute("recentBookList") == null){
            ArrayList<ProductRecentDTO> recentBookList = new ArrayList<>();
            session.setAttribute("recentBookList",recentBookList);
            return true;
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
