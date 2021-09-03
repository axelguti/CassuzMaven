package com.dao;

import com.DTO.CargaDatos;
import com.conexion.Conexion;
import com.interfaces.DataInterface;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CargaDatosDAO implements DataInterface {
    private Connection cn;
    private CallableStatement stm=null;
    @Override
    public String grabar(CargaDatos cargaDatos) {
        return null;
    }

    @Override
    public String modificar(CargaDatos cargaDatos) {
        return null;
    }

    @Override
    public String eliminar(Object id) {
        return null;
    }

    @Override
    public List<CargaDatos> listar() {
        List<CargaDatos> listar=new ArrayList<>();
        try {
            cn= Conexion.getConexion();
            stm= Objects.requireNonNull(cn).prepareCall("SP_R_CARGARDATOSCOMBOBOX");
            ResultSet rs=stm.executeQuery();
            CargaDatos obj;
            while (rs.next()){
                obj=new CargaDatos();
                obj.setData(rs.getString("estadopedido"));
                listar.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listar;
    }
}
