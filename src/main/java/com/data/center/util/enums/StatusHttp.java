package com.data.center.util.enums;

public enum StatusHttp {
    RECHARGE_CREATED("Recarga creada exitosamente"),
    GET_ALL_RECHARGES("Recargas encontradas exitosamente"),
    GET_ALL_OPERATORS("Operadores encontrados exitosamente"),
    GET_ALL_SALES("Vendedores encontrados exitosamente");
    private String message;

    StatusHttp(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
