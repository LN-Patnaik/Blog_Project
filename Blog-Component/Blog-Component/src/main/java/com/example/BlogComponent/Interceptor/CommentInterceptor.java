package com.example.BlogComponent.Interceptor;
import com.example.BlogComponent.Utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CommentInterceptor implements HandlerInterceptor {

    @Autowired
    ValidationUtils validationUtils;

    @Override
    public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

       String comment= request.getParameter("text");

       if(!validationUtils.validateBadWords(comment))
       {
           throw new Exception("Bad words are not allowed");
       }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
