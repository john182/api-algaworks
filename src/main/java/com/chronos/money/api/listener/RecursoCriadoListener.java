package com.chronos.money.api.listener;

import com.chronos.money.api.evento.RecursoCriadoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

/**
 * Created by john on 09/10/17.
 */
@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

    @Override
    public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
        HttpServletResponse response = recursoCriadoEvent.getResponse();
        Long codigo  = recursoCriadoEvent.getCodigo();

        adicionarHeaderLocation(response, codigo);
    }

    @EventListener
    public void handleResponseLocationHeader(RecursoCriadoEvent event) {
        HttpServletResponse response = event.getResponse();
        Long codigoRecurso = event.getCodigo();

        URI locationURI = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{codigo}")
                .buildAndExpand(codigoRecurso)
                .toUri();

        response.addHeader("Location", locationURI.toASCIIString());
    }

    private void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(codigo).toUri();
        response.setHeader("Location",uri.toASCIIString());
    }
}
