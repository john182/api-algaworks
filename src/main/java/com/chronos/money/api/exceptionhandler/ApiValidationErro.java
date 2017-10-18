package com.chronos.money.api.exceptionhandler;

/**
 * Created by john on 06/10/17.
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class ApiValidationErro extends ApiSubErro {

    private String objeto;
    private String campo;
    private Object valorRejeitado;
    private String mensagem;

    public ApiValidationErro(String objeto, String mensagem) {
        this.objeto = objeto;
        this.mensagem = mensagem;
    }

    public ApiValidationErro(String objeto, String campo, Object valorRejeitado, String mensagem) {
        this.objeto = objeto;
        this.campo = campo;
        this.valorRejeitado = valorRejeitado;
        this.mensagem = mensagem;
    }
}
