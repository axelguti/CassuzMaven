package com.Reportes;

import com.DAOFactory.DAOFactory;
import com.DTO.PedidosDTO;
import com.interfaces.PedidoInterface;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import javax.swing.*;
import java.io.*;
import java.util.List;

public class PromotorGanancia {

    public static void PromotorG(File f){
        XSSFWorkbook wb = new XSSFWorkbook();                // crea libro
        XSSFSheet sheet = wb.createSheet("Promotores");    // crea hoja
        XSSFRow row=sheet.createRow(0);
        row.createCell(0).setCellValue("Nro");
        row.createCell(1).setCellValue("DNI");
        row.createCell(2).setCellValue("Nombres");
        row.createCell(3).setCellValue("Apellidos");
        row.createCell(4).setCellValue("Monto");
        PedidoInterface dao= DAOFactory.getPedidoDAO();
        List<PedidosDTO> listar=dao.reportePromotor();
        int i=1;
        for (PedidosDTO p:listar){
            row = sheet.createRow((short) i);			// crea fila2
            row.createCell((short) 0).setCellValue("" + i);	// A2
            row.createCell((short) 1).setCellValue(p.getDni());		// B2
            row.createCell((short) 2).setCellValue(p.getNombre());
            row.createCell((short) 3).setCellValue(p.getApellido());
            row.createCell((short) 4).setCellValue(p.getPrecio());
            i++;
        }
        try (OutputStream fileout=new FileOutputStream(f)){
            JOptionPane.showMessageDialog(null,"Reporte Creado","Save",1);
            wb.write(fileout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void FechaPedido(File f) {
        XSSFWorkbook wb = new XSSFWorkbook();                // crea libro
        XSSFSheet sheet = wb.createSheet("Fecha");    // crea hoja
        XSSFRow row=sheet.createRow(0);
        row.createCell(0).setCellValue("Nro");
        row.createCell(1).setCellValue("Catalogo");
        row.createCell(2).setCellValue("Monto Total");
        row.createCell(3).setCellValue("mes");
        row.createCell(4).setCellValue("año");
        PedidoInterface dao= DAOFactory.getPedidoDAO();
        List<PedidosDTO> listar=dao.reporteFecha();
        int i=1;
        for (PedidosDTO p:listar){
            row = sheet.createRow((short) i);			// crea fila2
            row.createCell((short) 0).setCellValue("" + i);	// A2
            row.createCell((short) 1).setCellValue(p.getNomCatalogo());		// B2
            row.createCell((short) 2).setCellValue(p.getPrecio());
            row.createCell((short) 3).setCellValue(p.getMes());
            row.createCell((short) 4).setCellValue(p.getFecha());
            i++;
        }
        try (OutputStream fileout=new FileOutputStream(f)){
            JOptionPane.showMessageDialog(null,"Reporte Creado","Save",1);
            wb.write(fileout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static XSSFCellStyle Cabecera(XSSFWorkbook wb){
        XSSFCellStyle styleCabecera=wb.createCellStyle();
        XSSFFont cabecera = wb.createFont();
        XSSFColor xssfColor = cabecera.getXSSFColor();
        styleCabecera.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cabecera.setBold(true);
        styleCabecera.setFont(cabecera);
        styleCabecera.setAlignment(HorizontalAlignment.CENTER);
        styleCabecera.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        return styleCabecera;
    }
    public static XSSFCellStyle Cuerpo(XSSFWorkbook wb){
        XSSFCellStyle styleContenido=wb.createCellStyle();
        XSSFFont cuerpo = wb.createFont();
        cuerpo.setBold(false);
        styleContenido.setFont(cuerpo);
        styleContenido.setAlignment(HorizontalAlignment.CENTER);
        return styleContenido;
    }
    public static void ReporteMes(File file) {
        XSSFWorkbook wb=new XSSFWorkbook();
        XSSFSheet sheet=wb.createSheet("Reporte del Mes");
        XSSFRow xssfRow = sheet.createRow(0);
        sheet.setColumnWidth(0,1200);
        sheet.setColumnWidth(2,8000);
        XSSFCellStyle cabecera=Cabecera(wb);
        XSSFCellStyle cuerpo=Cuerpo(wb);

        XSSFCell cell1=xssfRow.createCell((short) 0);
        cell1.setCellValue("Nro");

        XSSFCell cell2=xssfRow.createCell((short) 1);
        cell2.setCellValue("Mes");
        XSSFCell cell3=xssfRow.createCell((short) 2);
        cell3.setCellValue("Monto Total");
        XSSFCell cell4=xssfRow.createCell((short) 3);
        cell4.setCellValue("año");
        cell1.setCellStyle(cabecera);
        cell1.setCellStyle(cabecera);
        cell2.setCellStyle(cabecera);
        cell3.setCellStyle(cabecera);
        cell4.setCellStyle(cabecera);
        PedidoInterface dao=DAOFactory.getPedidoDAO();
        List<PedidosDTO> listar=dao.reporteMes();
        int i=1;

        for(PedidosDTO p:listar){

            xssfRow=sheet.createRow((short) i);
            cell1=xssfRow.createCell((short) 0);
            cell1.setCellValue(" "+i);
            cell2=xssfRow.createCell((short) 1);
            cell2.setCellValue(p.getMes());
            cell3=xssfRow.createCell((short) 2);
            cell3.setCellValue(p.getPrecio());
            cell4=xssfRow.createCell((short) 3);
            cell4.setCellValue(p.getFecha());
            cell1.setCellStyle(cuerpo);
            cell2.setCellStyle(cuerpo);
            cell3.setCellStyle(cuerpo);
            cell4.setCellStyle(cuerpo);
            i++;
        }
        try(OutputStream out=new FileOutputStream(file)){
            JOptionPane.showMessageDialog(null,"Reporte Creado","Save",1);
            wb.write(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
