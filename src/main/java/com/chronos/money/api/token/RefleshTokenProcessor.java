package com.chronos.money.api.token;

import com.chronos.money.api.config.properties.ApiProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by john on 16/10/17.
 */
@ControllerAdvice
public class RefleshTokenProcessor implements ResponseBodyAdvice<OAuth2AccessToken> {

    @Autowired
    private ApiProperty apiProperty;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return methodParameter.getMethod().getName().equals("postAccessToken");
    }

    @Override
    public OAuth2AccessToken beforeBodyWrite(OAuth2AccessToken oAuth2AccessToken, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        String refleshToekn = oAuth2AccessToken.getRefreshToken().getValue();

        HttpServletRequest request =  ((ServletServerHttpRequest)serverHttpRequest).getServletRequest();
        HttpServletResponse response = ((ServletServerHttpResponse)serverHttpResponse).getServletResponse();



        adicionarRefleshCookie(refleshToekn,request,response);

        DefaultOAuth2AccessToken token  = (DefaultOAuth2AccessToken)oAuth2AccessToken;
        removerRefleshTokenBody(token);

        return oAuth2AccessToken;
    }

    private void removerRefleshTokenBody(DefaultOAuth2AccessToken token) {
        token.setRefreshToken(null);
    }

    private void adicionarRefleshCookie(String refleshToekn, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("refleshToken",refleshToekn);
        cookie.setHttpOnly(true);

        cookie.setSecure(apiProperty.getSeguranca().isEnableHttps());
        cookie.setPath(request.getContextPath()+"/oauth/token");
        cookie.setMaxAge(2592000);
        response.addCookie(cookie);


    }


}