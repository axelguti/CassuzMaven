package com.DTO;

public class ListaPreciosDTO {
    private int codigo;
    private String catalogo;
    private int pagina;
    private String marca;
    private String estilo;
    private String descripcion;
    private double preciopublico;
    private double preciopromotor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
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

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPreciopublico() {
        return preciopublico;
    }

    public void setPreciopublico(double preciopublico) {
        this.preciopublico = preciopublico;
    }

    public double getPreciopromotor() {
        return preciopromotor;
    }

    public void setPreciopromotor(double preciopromotor) {
        this.preciopromotor = preciopromotor;
    }

    public void Imprimir() {
        System.out.println(getPagina());
        System.out.println(getMarca());
        System.out.println(getCodigo());
        System.out.println(getDescripcion());
        System.out.println(getPreciopublico());
        System.out.println(getPreciopromotor());
    }
}
