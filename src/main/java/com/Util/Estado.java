package com.Util;

public enum Estado {
        HABILITADO("HABILITADO"),
    DESHABILITADO("DESHABILITADO");
    public final String s;
    Estado(String s) {this.s=s;}

    public String getS() {
        return s;
    }
}
