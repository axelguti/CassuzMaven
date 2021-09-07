package com.Reportes;

import com.DAOFactory.DAOFactory;
import com.DTO.PedidosDTO;
import com.interfaces.PedidoInterface;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import javax.swing.*;
import java.io.*;
import java.util.List;

public class PromotorGanancia {


    private static XSSFWorkbook wb = new XSSFWorkbook();
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCreationHelper creationHelper;

    public static void PromotorG(File f){
               // crea libro
        sheet = wb.createSheet(f.toString());    // crea hoja
        row=sheet.createRow(0);
        XSSFCellStyle cabecera=Cabecera(wb);
        XSSFCellStyle cuerpo=Cuerpo(wb);
        XSSFCell cell1=row.createCell(0);
        cell1.setCellValue("Nro");
        XSSFCell cell2=row.createCell(1);
        cell2.setCellValue("DNI");
        XSSFCell cell3=row.createCell(2);
        cell3.setCellValue("Nombres");
        XSSFCell cell4=row.createCell(3);
        cell4.setCellValue("Apellidos");
        XSSFCell cell5=row.createCell(4);
        cell5.setCellValue("Monto");
        cell1.setCellStyle(cabecera);
        cell2.setCellStyle(cabecera);
        cell3.setCellStyle(cabecera);
        cell4.setCellStyle(cabecera);
        cell5.setCellStyle(cabecera);
        PedidoInterface dao= DAOFactory.getPedidoDAO();
        List<PedidosDTO> listar=dao.reportePromotor();
        int i=1;
        for (PedidosDTO p:listar){
            row = sheet.createRow((short) i);
            cell1=row.createCell(0);
            cell1.setCellValue(" "+ i);
            cell2=row.createCell(1);
            cell2.setCellValue(p.getDni());
            cell3=row.createCell(2);
            cell3.setCellValue(p.getNombre());
            cell4=row.createCell(3);
            cell4.setCellValue(p.getApellido());
            cell5=row.createCell(4);
            cell5.setCellValue(p.getPrecio());
            cell1.setCellStyle(cuerpo);
            cell2.setCellStyle(cuerpo);
            cell3.setCellStyle(cuerpo);
            cell4.setCellStyle(cuerpo);
            cell5.setCellStyle(cuerpo);// crea fila2
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
                        // crea libro
        sheet = wb.createSheet(f.toString());    // crea hoja
        XSSFRow row=sheet.createRow(0);

        XSSFCellStyle cabecera=Cabecera(wb);
        XSSFCellStyle cuerpo=Cuerpo(wb);

        XSSFCell cell1=row.createCell(0);
        cell1.setCellValue("Nro");
        XSSFCell cell2=row.createCell(1);
        cell2.setCellValue("Catalogo");
        XSSFCell cell3=row.createCell(2);
        cell3.setCellValue("Monto Total");
        XSSFCell cell4=row.createCell(3);
        cell4.setCellValue("mes");
        XSSFCell cell5=row.createCell(4);
        cell5.setCellValue("año");
        cell1.setCellStyle(cabecera);
        cell2.setCellStyle(cabecera);
        cell3.setCellStyle(cabecera);
        cell4.setCellStyle(cabecera);
        cell5.setCellStyle(cabecera);
        PedidoInterface dao= DAOFactory.getPedidoDAO();
        List<PedidosDTO> listar=dao.reporteFecha();
        int i=1;
        for (PedidosDTO p:listar){
            row = sheet.createRow((short) i);			// crea fila2
            cell1=row.createCell((short) 0);
            cell1.setCellValue(" "+i);
            cell2=row.createCell(1);
            cell2.setCellValue(p.getNomCatalogo());
            cell3=row.createCell(2);
            cell3.setCellValue(p.getPrecio());
            cell4=row.createCell(3);
            cell4.setCellValue(p.getMes());
            cell5=row.createCell(4);
            cell5.setCellValue(p.getFecha());
            cell1.setCellStyle(cuerpo);
            cell2.setCellStyle(cuerpo);
            cell3.setCellStyle(cuerpo);
            cell4.setCellStyle(cuerpo);
            cell5.setCellStyle(cuerpo);
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
        styleCabecera.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cabecera.setBold(true);
        styleCabecera.setBorderBottom(BorderStyle.MEDIUM);
        styleCabecera.setBorderTop(BorderStyle.MEDIUM);
        styleCabecera.setBorderLeft(BorderStyle.MEDIUM);
        styleCabecera.setBorderRight(BorderStyle.MEDIUM);
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
        XSSFSheet sheet=wb.createSheet(file.toString());
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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void ReporteTotalPedido(File file) {
        creationHelper= wb.getCreationHelper();
        XSSFSheet sheet=wb.createSheet(file.toString());
        XSSFRow xssfRow = sheet.createRow(0);
        sheet.setColumnWidth(0,1200);
        sheet.setColumnWidth(2,8000);
        sheet.setColumnWidth(8,8000);
        sheet.setColumnWidth(3,4000);
        sheet.setColumnWidth(11,4000);
        sheet.setColumnWidth(9,3500);
        sheet.setColumnWidth(10,3500);
        XSSFCellStyle cabecera=Cabecera(wb);
        XSSFCellStyle cuerpo=Cuerpo(wb);
        XSSFCellStyle formatfech=Cuerpo(wb);
        XSSFCell cell1=xssfRow.createCell((short) 0);
        cell1.setCellValue("Nro");
        XSSFCell cell2=xssfRow.createCell((short) 1);
        cell2.setCellValue("DNI");
        XSSFCell cell3=xssfRow.createCell((short) 2);
        cell3.setCellValue("Nombres");
        XSSFCell cell4=xssfRow.createCell((short) 3);
        cell4.setCellValue("Catalogo");
        XSSFCell cell5=xssfRow.createCell((short) 4);
        cell5.setCellValue("Codigo");
        XSSFCell cell6=xssfRow.createCell((short) 5);
        cell6.setCellValue("Marca");
        XSSFCell cell7=xssfRow.createCell((short) 6);
        cell7.setCellValue("color");
        XSSFCell cell8=xssfRow.createCell((short) 7);
        cell8.setCellValue("Precio");
        XSSFCell cell9=xssfRow.createCell((short) 8);
        cell9.setCellValue("Fecha");
        XSSFCell cell10=xssfRow.createCell((short) 9);
        cell10.setCellValue("Tipo Pago");
        XSSFCell cell11=xssfRow.createCell((short) 10);
        cell11.setCellValue("Banco");
        XSSFCell cell12=xssfRow.createCell((short) 11);
        cell12.setCellValue("Estado");


        cell1.setCellStyle(cabecera);
        cell1.setCellStyle(cabecera);
        cell2.setCellStyle(cabecera);
        cell3.setCellStyle(cabecera);
        cell4.setCellStyle(cabecera);
        cell5.setCellStyle(cabecera);
        cell6.setCellStyle(cabecera);
        cell7.setCellStyle(cabecera);
        cell8.setCellStyle(cabecera);
        cell9.setCellStyle(cabecera);
        cell10.setCellStyle(cabecera);
        cell11.setCellStyle(cabecera);
        PedidoInterface dao=DAOFactory.getPedidoDAO();
        List<PedidosDTO> listar=dao.listar();
        int i=1;

        for(PedidosDTO p:listar){
            formatfech.setDataFormat(creationHelper.createDataFormat().
                    getFormat("MMMM dd, yyyy"));
            xssfRow=sheet.createRow((short) i);
            cell1=xssfRow.createCell((short) 0);
            cell1.setCellValue(" "+i);
            cell2=xssfRow.createCell((short) 1);
            cell2.setCellValue(p.getDni());
            cell3=xssfRow.createCell((short) 2);
            cell3.setCellValue(p.getNombre());
            cell4=xssfRow.createCell((short) 3);
            cell4.setCellValue(p.getNomCatalogo());
            cell5=xssfRow.createCell((short) 4);
            cell5.setCellValue(p.getCodProducto());
            cell6=xssfRow.createCell((short) 5);
            cell6.setCellValue(p.getMarca());
            cell7=xssfRow.createCell((short) 6);
            cell7.setCellValue(p.getColor());
            cell8=xssfRow.createCell((short) 7);
            cell8.setCellValue(p.getPrecio());
            cell9=xssfRow.createCell((short) 8);
            cell9.setCellValue(p.getFechaPedido());
            cell10=xssfRow.createCell((short) 9);
            cell10.setCellValue(p.getTipopago());
            cell11=xssfRow.createCell((short) 10);
            cell11.setCellValue(p.getBanco());
            cell12=xssfRow.createCell((short) 11);
            cell12.setCellValue(p.getEs());
            cell1.setCellStyle(cuerpo);
            cell2.setCellStyle(cuerpo);
            cell3.setCellStyle(cuerpo);
            cell4.setCellStyle(cuerpo);
            cell5.setCellStyle(cuerpo);
            cell6.setCellStyle(cuerpo);
            cell7.setCellStyle(cuerpo);
            cell8.setCellStyle(cuerpo);
            cell9.setCellStyle(formatfech);
            cell10.setCellStyle(cuerpo);
            cell11.setCellStyle(cuerpo);
            cell12.setCellStyle(cuerpo);
            i++;
        }

        try(OutputStream out=new FileOutputStream(file)){
            JOptionPane.showMessageDialog(null,"Reporte Creado","Save",1);
            wb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
