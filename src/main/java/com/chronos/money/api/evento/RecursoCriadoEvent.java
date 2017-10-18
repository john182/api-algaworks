package com.chronos.money.api.evento;


import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by john on 09/10/17.
 */
public class RecursoCriadoEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1l;


    private  HttpServletResponse response;
    private Long codigo;

    public RecursoCriadoEvent(Object source, HttpServletResponse response,Long codigo) {
        super(source);
        this.response = response;
        this.codigo = codigo;
    }


    public HttpServletResponse getResponse() {
        return response;
    }

    public Long getCodigo() {
        return codigo;
    }
}
