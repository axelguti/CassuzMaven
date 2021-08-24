package com.dao;

import com.DTO.PedidosDTO;
import com.conexion.Conexion;
import com.interfaces.PedidoInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PedidoDAO implements PedidoInterface {

    private Connection cn;
    private CallableStatement stm=null;

    @Override
    public String grabar(PedidosDTO pedidosDTO) {
        String result = "";

        try{
            cn= Conexion.getConexion();
            stm = Objects.requireNonNull(cn).prepareCall("EXEC SP_C_PEDIDO ?,?,?,?,?,?,?,?,?,?,?,?");
            stm.setString(1, pedidosDTO.getDni());
            stm.setString(2, pedidosDTO.getNomCatalogo());
            stm.setInt(3, pedidosDTO.getPagina());
            stm.setString(4, pedidosDTO.getCodProducto());
            stm.setString(5, pedidosDTO.getMarca());
            stm.setString(6, pedidosDTO.getColor());
            stm.setString(7, pedidosDTO.getTalla());
            stm.setDouble(8, pedidosDTO.getPrecio());
            stm.setString(9,pedidosDTO.getTipopago());
            stm.setString(10,pedidosDTO.getBanco());
            stm.setString(11, pedidosDTO.getFechaPedido().toString());
            stm.setString(12,pedidosDTO.getEs());
            stm.executeUpdate();
            result="Pedido Registrado Exitosamente";
            stm.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    @Override
    public String modificar(PedidosDTO pedidosDTO) {
        String result ="";
        try {
            cn =Conexion.getConexion();
            stm = Objects.requireNonNull(cn).prepareCall("EXEC SP_U_PEDIDO ?,?,?,?,?,?,?,?,?");
            stm.setInt(1, pedidosDTO.getIdPedido());
            stm.setString(2, pedidosDTO.getDni());
            stm.setString(3, pedidosDTO.getNomCatalogo());
            stm.setInt(4, pedidosDTO.getPagina());
            stm.setString(5, pedidosDTO.getCodProducto());
            stm.setString(6, pedidosDTO.getMarca());
            stm.setString(7, pedidosDTO.getColor());
            stm.setString(8, pedidosDTO.getTalla());
            stm.setString(9,pedidosDTO.getTipopago());
            stm.setString(10,pedidosDTO.getBanco());
            stm.setString(11, pedidosDTO.getFechaPedido().toString());
            stm.executeUpdate();
            result="Pedido Modificado Exitosamente";
            stm.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public String eliminar(Object id) {
        String result="";

        try {
            cn=Conexion.getConexion();
            stm= Objects.requireNonNull(cn).prepareCall("exec SP_D_PEDIDO ?");
            stm.setString(1,id.toString());
            stm.executeUpdate();
            result="Registro Eliminado Satisfactoriamente";
            stm.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public List<PedidosDTO> listar() {
        List<PedidosDTO> listar=new ArrayList<>();

        try{
            cn=Conexion.getConexion();
            stm=Objects.requireNonNull(cn).prepareCall("exec SP_R_PEDIDO");
            ResultSet rs=stm.executeQuery();
            PedidosDTO p;
            while(rs.next()){
                p=new PedidosDTO();
                p.setIdPedido(rs.getInt("idpedido"));
                p.setDni(rs.getString("dnipromotor"));
                p.setNombre(rs.getString("nompromotor"));
                p.setApellido(rs.getString("apepromotor"));
                p.setNomCatalogo(rs.getString("nomcatalogo"));
                p.setPagina(rs.getInt("pagcatalogo"));
                p.setCodProducto(rs.getString("codproducto"));
                p.setMarca(rs.getString("marcaproducto"));
                p.setColor(rs.getString("colorproducto"));
                p.setTalla(rs.getString("tallaproducto"));
                p.setPrecio(rs.getDouble("precioproducto"));
                p.setTipopago(rs.getString("tipopago"));
                p.setBanco(rs.getString("banco"));
                p.setFechaPedido(LocalDate.parse(rs.getString("fechapedido")));
                p.setEs(rs.getString("estadopedido"));
                listar.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listar;
    }

    @Override
    public String modificarEstado(PedidosDTO p) {
        String result ="";

        try {
            cn=Conexion.getConexion();
            stm= Objects.requireNonNull(cn).prepareCall("exec SP_U_PEDIDOESTADO ?,?");
            stm.setInt(1, p.getIdPedido());
            stm.setString(2,p.getEs());
            stm.executeUpdate();
            result="Modificado Satisfactoriamente";
            stm.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  result;
    }

    @Override
    public List<PedidosDTO> reportePedido() {
        List<PedidosDTO> listar=new ArrayList<>();
        try{
            cn=Conexion.getConexion();
            stm= Objects.requireNonNull(cn).prepareCall("EXEC SP_R_REPORTEMES");
            ResultSet rs=stm.executeQuery();
            PedidosDTO obj;
            while(rs.next()){
                obj=new PedidosDTO();
                obj.setMes(rs.getString("mes"));
                obj.setPrecio(rs.getDouble("total"));
                listar.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listar;
    }

    @Override
    public List<PedidosDTO> reporteCircular() {
        List<PedidosDTO> listar=new ArrayList<>();
        try{
            cn=Conexion.getConexion();
            stm= Objects.requireNonNull(cn).prepareCall("exec SP_R_REPORTECIRCULARCATALOGO");
            ResultSet rs=stm.executeQuery();
            PedidosDTO obj;
            while(rs.next()){
                obj=new PedidosDTO();
                obj.setNomCatalogo(rs.getString(1));
                obj.setPrecio(rs.getDouble(2));
                listar.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listar;
    }

    @Override
    public ObservableList<PedidosDTO> getPedidos() {
        ObservableList<PedidosDTO> obs= FXCollections.observableArrayList();

        try{
            cn=Conexion.getConexion();
            stm= Objects.requireNonNull(cn).prepareCall("exec SP_R_CARGARDATOSCOMBOBOX");
            ResultSet rs=stm.executeQuery();
            PedidosDTO obj;
            while(rs.next()){
                obj=new PedidosDTO();
                obj.setEs(rs.getString("estadopedido"));
                obs.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obs;
    }
}
