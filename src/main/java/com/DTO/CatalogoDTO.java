package com.DTO;


import com.jfoenix.controls.JFXToggleButton;

public class CatalogoDTO {
    private int id;
    private String nombre;
    private String representante;
    private String telefono;
    private String estado;
    private JFXToggleButton buton;


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRepresentante(){
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public JFXToggleButton getButon() {
        buton=new JFXToggleButton();
        return validarToogleButton(buton);
    }

    public JFXToggleButton validarToogleButton(JFXToggleButton buton){
        if(getEstado().equalsIgnoreCase("Habilitado")){
            buton.setSelected(true);
        }else if(getEstado().equalsIgnoreCase("Deshabilitado")){
            buton.setSelected(false);
        }
        return buton;
    }

    public void setButon(JFXToggleButton buton) {
        this.buton = buton;
    }

    public void Imprimir(){
        System.out.println(getId());
        System.out.println(getNombre());
        System.out.println(getRepresentante());
        System.out.println(getTelefono());
        System.out.println(getEstado());
    }
}
