package com.chronos.money.api.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * Created by john on 18/10/17.
 */

@ConfigurationProperties("chronosmoney")
public class ApiProperty {

    private String originPermitida = "http://localhost:4200";

    private final Seguranca seguranca = new Seguranca();

    public Seguranca getSeguranca() {
        return seguranca;
    }

    public String getOriginPermitida() {
        return originPermitida;
    }

    public void setOriginPermitida(String originPermitida) {
        this.originPermitida = originPermitida;
    }

    public static class Seguranca {

        private boolean enableHttps;

        public boolean isEnableHttps() {
            return enableHttps;
        }

        public void setEnableHttps(boolean enableHttps) {
            this.enableHttps = enableHttps;
        }

    }

}
