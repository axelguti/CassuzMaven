package com.Reportes;

import org.apache.poi.xssf.usermodel.*;

import java.io.File;

public class ReporteCaja {

    private static XSSFWorkbook wb = new XSSFWorkbook();
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCreationHelper creationHelper;


    private void ReporteCajaTotal(File file){
        sheet=wb.createSheet(file.toString());
        row=sheet.createRow(0);
        XSSFCellStyle cabecera=PromotorGanancia.Cabecera(wb);
        XSSFCellStyle cuerpo=PromotorGanancia.Cuerpo(wb);

        XSSFCell cell1=row.createCell((short) 0);
        cell1.setCellValue("Nro");
        XSSFCell cell2=row.createCell((short) 1);
        cell2.setCellValue("Codigo de la Caja");
        XSSFCell cell3=row.createCell((short) 2);
        cell3.setCellValue("Descripcion");
        XSSFCell cell4=row.createCell((short) 3);
        cell4.setCellValue("Monto");
        XSSFCell cell5=row.createCell((short) 4);
        cell5.setCellValue("Hora");
        XSSFCell cell6=row.createCell((short) 5);
        cell6.setCellValue("fecha");


    }
}
