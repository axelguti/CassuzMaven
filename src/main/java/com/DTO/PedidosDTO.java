package com.DTO;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.ComboBox;

import java.time.LocalDate;

public class PedidosDTO extends PromotorDTO{
    private int idPedido;
    private LocalDate fechaPedido;
    private String nomCatalogo;
    private int pagina;
    private String marca;
    private String color;
    private double precio;
    private String talla;
    private String codProducto;
    private String tipopago;
    private String banco;
    private ComboBox<String> estado;
    private String es;
    private String mes;
    private String fecha;

    public PedidosDTO(){}

    public PedidosDTO(String dni, String nombre, String apellido, int idPedido, LocalDate fechaPedido, String nomCatalogo,
                      int pagina, String marca, String color, double precio, String talla, String codProducto, String tipopago,String banco) {
        super(dni, nombre, apellido);
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.nomCatalogo = nomCatalogo;
        this.pagina = pagina;
        this.marca = marca;
        this.color = color;
        this.precio = precio;
        this.talla = talla;
        this.codProducto = codProducto;
        this.tipopago = tipopago;
        this.banco = banco;

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMes() {
        return mes;
    }

    public PedidosDTO setMes(String mes) {
        this.mes = mes;
        return this;
    }

    public void estados(){
        switch (getEs()){
            case "Proceso":{
                estado.getSelectionModel().select("Proceso");
            }break;
            case "En Almacen":{
                estado.getSelectionModel().select("En Almacen");
            }break;
            case "Entregado":{
                estado.getSelectionModel().select("Entregado");
            }
        }
    }

    public void setEstado(ComboBox<String> estado) {

        this.estado = estado;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es=es;
    }

    public ComboBox<String> getEstado() {

        return estado;
    }


    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;

    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getNomCatalogo() {
        return nomCatalogo;
    }

    public void setNomCatalogo(String nomCatalogo) {
        this.nomCatalogo = nomCatalogo;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public void imprimir(){
        System.out.println(getEs());
    }


}