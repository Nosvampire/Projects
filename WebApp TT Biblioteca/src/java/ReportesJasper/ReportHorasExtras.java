/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportesJasper;

import POJO.Prestamo;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author nicolas.molina
 */
public class ReportHorasExtras {

    public void crearReporteHorasExtras(List<Prestamo> listHorasExtra,String nombre, String rut,String totalTrabajado, String totalExtra,String fecha,String hora) {
        HashMap<String, Object> parametros = new HashMap();
        String jrxmlPath = "/Perfil_Alumnos/reportes/reportePrestamos.jrxml";
        parametros.put("rut", rut);
        parametros.put("nombre", nombre);
        parametros.put("fecha", fecha);
        parametros.put("hora", hora);
        parametros.put("totalTrabajado", totalTrabajado);
        parametros.put("totalExtra", totalExtra);
        
        CompiladorJasper compiladorJasper = new CompiladorJasper();
         JasperPrint jasperPrin = compiladorJasper.jasperPrint(jrxmlPath, parametros, new JRBeanCollectionDataSource(listHorasExtra));
         ExporterJasperPDF exporterJasper = new ExporterJasperPDF();

        exporterJasper.exportDicoPDF(jasperPrin, "HorasExtras.pdf");
    }

}
