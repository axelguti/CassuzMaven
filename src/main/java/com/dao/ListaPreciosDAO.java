package com.dao;

import com.DTO.ListaPreciosDTO;
import com.conexion.Conexion;
import com.interfaces.ListaPrecioInterface;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListaPreciosDAO implements ListaPrecioInterface {
    private Connection cn;
    private CallableStatement stm = null;

    @Override
    public String grabar(ListaPreciosDTO productos) {
        String result = "";
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("exec SP_C_LISTAPRECIO ?,?,?,?,?,?,?");
            stm.setInt(1, productos.getPagina());
            stm.setString(2, productos.getMarca());
            stm.setString(3, productos.getEstilo());
            stm.setString(4, productos.getDescripcion());
            stm.setDouble(5, productos.getPreciopublico());
            stm.setDouble(6, productos.getPreciopromotor());
            stm.setString(7, productos.getCatalogo());
            int f = stm.executeUpdate();
            result = "se afecto " + f + " filas";
            stm.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public String modificar(ListaPreciosDTO productos) {
        return null;
    }

    @Override
    public String eliminar(Object id) {
        return null;
    }

    @Override
    public List<ListaPreciosDTO> listar() {
        List<ListaPreciosDTO> listar = new ArrayList<>();
        try {
            cn = Conexion.getConexion();
            stm = Objects.requireNonNull(cn).prepareCall("exec SP_R_LISTAPRECIO");
            ResultSet rs = stm.executeQuery();
            ListaPreciosDTO obj;
            while (rs.next()) {
                obj = new ListaPreciosDTO();
                obj.setCodigo(rs.getInt("idproducto"));
                obj.setPagina(rs.getInt("pagproducto"));
                obj.setDescripcion(rs.getString("descripcionproducto"));
                obj.setMarca(rs.getString("marcaproducto"));
                obj.setEstilo(rs.getString("estiloproducto"));
                obj.setPreciopublico(rs.getDouble("preciopublicoproducto"));
                obj.setPreciopromotor(rs.getDouble("preciopromotorproducto"));
                listar.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listar;
    }


    @Override
    public String Importar(File file) throws IOException {
        String result ="";
        ListaPreciosDTO precio;
        FileInputStream fi=new FileInputStream(file);
        XSSFWorkbook libro=new XSSFWorkbook(fi);
        XSSFSheet hoja=libro.getSheetAt(0);
        XSSFRow row=hoja.getRow(2);
        XSSFCell cell1=row.getCell(0);
        XSSFCell cell2=row.getCell(1);
        XSSFCell cell3=row.getCell(2);
        XSSFCell cell4=row.getCell(3);
        XSSFCell cell5=row.getCell(4);
        XSSFCell cell6=row.getCell(5);
        XSSFCell cell7=row.getCell(6);
        int i=1;

        return result;
    }
}

