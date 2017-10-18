package com.chronos.money.api.token;

import org.apache.catalina.util.ParameterMap;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Map;

/**
 * Created by john on 16/10/17.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RefleshTokenCookiePreProcessorFilter implements Filter {




    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;

        if("/oauth/token".equalsIgnoreCase(req.getRequestURI())
                && "reflesh_token".equals(req.getParameter("grant_type"))
                && req.getCookies()!=null){


            for(Cookie cookie : req.getCookies()){
                if(cookie.getName().equals("refleshToken")){
                    String refleshToken = cookie.getValue();
                    req = new MyServletRequestWrapper(req,refleshToken);
                    break;
                }
            }
        }

        chain.doFilter(req,response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }


    static class MyServletRequestWrapper extends HttpServletRequestWrapper{

        private String refleshToken;

        public MyServletRequestWrapper(HttpServletRequest request,String refleshToken) {
            super(request);
            this.refleshToken = refleshToken;
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            ParameterMap<String,String[]> map = new ParameterMap<>(getRequest().getParameterMap());
            map.put("refleshToken",new String[]{refleshToken});
            map.setLocked(true);
            return map;
        }
    }
}
