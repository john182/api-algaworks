package com.chronos.money.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Created by john on 15/10/17.
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
                //usuario e senha do cliente( da aplicação que está fazendo a requisição)
                .withClient("angula").secret("@ngul@")
                // escopo usado para o acesso a api
                .scopes("read","write")
                //
                .authorizedGrantTypes("password","reflesh_token")
                // tempo definido para o token
                .accessTokenValiditySeconds(1800)
                // tempo de vida do reflesh token
                .refreshTokenValiditySeconds(3600*24)
        .and()
                //usuario e senha do cliente( da aplicação que está fazendo a requisição)
                .withClient("mobile").secret("m0b1l3")
                // escopo usado para o acesso a api
                .scopes("read")
                //
                .authorizedGrantTypes("password","reflesh_token")
                // tempo definido para o token
                .accessTokenValiditySeconds(1800)
                // tempo de vida do reflesh token
                .refreshTokenValiditySeconds(3600*24);
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter())
                .reuseRefreshTokens(false)
                .authenticationManager(authenticationManager);
    }
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey("chronos");
        return accessTokenConverter;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());

    }
}
