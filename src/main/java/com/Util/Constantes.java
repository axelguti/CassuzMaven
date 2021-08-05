package com.Util;

public enum Constantes {
    HABILITADO(true),
    DESHABILITADO(false);
    private final boolean b;

    Constantes(boolean b) {
        this.b=b;
    }
    public boolean isB() {
        return b;
    }
    public static boolean validacion(Estado estado){
        boolean button=true;
        switch(estado){
            case HABILITADO: button=HABILITADO.isB();break;
            case DESHABILITADO: button= DESHABILITADO.isB();break;
        }
        return button;
    }
}
