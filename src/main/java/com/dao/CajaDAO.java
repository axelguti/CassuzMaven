package com.dao;

import com.DTO.CajaDTO;
import com.conexion.Conexion;
import com.interfaces.CajaInterface;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CajaDAO implements CajaInterface {
    private Connection cn;
    private CallableStatement stn;

    @Override
    public String grabar(CajaDTO cajaDTO) {
        String result = "";
        try{
            cn= Conexion.getConexion();
            stn= Objects.requireNonNull(cn).prepareCall("exec SP_C_CAJA ?,?,?,?");
            stn.setString(1,cajaDTO.getDescripcion());
            stn.setDouble(2,cajaDTO.getMonto());
            stn.setString(3, String.valueOf(cajaDTO.getHora()));
            stn.setString(4, String.valueOf(cajaDTO.getFecha()));
            stn.executeUpdate();
            result="Dato Registrado Correctamente";
            stn.close();
            cn.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public String modificar(CajaDTO cajaDTO) {
        return null;
    }

    @Override
    public String eliminar(Object id) {
        return null;
    }

    @Override
    public List<CajaDTO> listar() {
        List<CajaDTO> listar=new ArrayList<>();
        try{
            cn=Conexion.getConexion();
            stn= Objects.requireNonNull(cn).prepareCall("EXEC SP_R_CAJA");
            ResultSet rs=stn.executeQuery();
            CajaDTO obj;
            while (rs.next()){
                obj=new CajaDTO();
                obj.setIdcaja(rs.getInt("idcaja"));
                obj.setDescripcion(rs.getString("descripcion"));
                obj.setMonto(rs.getDouble("monto"));
                obj.setFecha(rs.getString("fecha"));
                obj.setHora(rs.getString("hora"));
                listar.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listar;
    }
}
