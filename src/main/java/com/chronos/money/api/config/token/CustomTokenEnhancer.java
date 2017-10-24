package com.chronos.money.api.config.token;

import com.chronos.money.api.security.UsuarioSistema;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by john on 19/10/17.
 */
public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        UsuarioSistema usuarioSistema = (UsuarioSistema) authentication.getPrincipal();

        Map<String, Object> addInfo = new HashMap<>();
        addInfo.put("nome", usuarioSistema.getUsuario().getNome());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);
        return accessToken;
    }
}
