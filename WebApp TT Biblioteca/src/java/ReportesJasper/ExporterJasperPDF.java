package ReportesJasper;

import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

/**
 *
 * PDF: net.sf.jasperreports.engine.exportJRPdfExporter HTML:
 * net.sf.jasperreports.engine.exportJRHtmlExporter CSV:
 * net.sf.jasperreports.engine.exportJRCsvExporter RTF:
 * net.sf.jasperreports.engine.exportJRRtfExporter XLS:
 * net.sf.jasperreports.engine.exportJRXlsExporter XML:
 * net.sf.jasperreports.engine.exportJRXmlExporter TXT:
 * net.sf.jasperreports.engine.exportJRTextExporter XLSX:
 * net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter DOCX:
 * net.sf.jasperreports.engine.export.ooxml.JRDocxExporter PPTX:
 * net.sf.jasperreports.engine.export.ooxml.JRPptxExporter
 */
/**
 *
 * @author Juan Delgado Robles
 */
public class ExporterJasperPDF implements Serializable {

    private final HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

    synchronized public void exportDicoPDF(JasperPrint jasperPrint, String nombreArchivo) {
        FileOutputStream fos = null;
        try {

            if (!(new File(Ruta.RUTA_DOWNLOAD).exists())) {
                (new File(Ruta.RUTA_DOWNLOAD)).mkdirs();
            }

            fos = new FileOutputStream(Ruta.RUTA_DOWNLOAD + nombreArchivo);

            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING,
                    "UTF-8");
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT,
                    jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
            exporter.exportReport();

            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control",
                    "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            response.setHeader("Content-Disposition", "attachment;filename=" + nombreArchivo + "");
            response.setContentType("text/pdf;charset=UTF-8");

            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
                    response.getOutputStream());

            exporter.exportReport();

            fos.flush();
            fos.close();
        } catch (JRException e) {
            System.out.println("Error [CompiladorJasper][jasperArrayListWeb][JRException]: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error [CompiladorJasper][jasperArrayListWeb][IOException]: " + e.getMessage());
        }
        FacesContext.getCurrentInstance().responseComplete();
    }
    synchronized public String serverDicoPDF(JasperPrint jasperPrint, String nombreArchivo) {
        FileOutputStream fos = null;
        String ruta = "";
        try {

            if (!(new File(Ruta.RUTA_DOWNLOAD).exists())) {
                (new File(Ruta.RUTA_DOWNLOAD)).mkdirs();
            }
            ruta=Ruta.RUTA_DOWNLOAD + nombreArchivo;
            fos = new FileOutputStream(ruta);

            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING,
                    "UTF-8");
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT,
                    jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
            exporter.exportReport();

            fos.flush();
            fos.close();
        } catch (JRException e) {
            System.out.println("Error [CompiladorJasper][jasperArrayListWeb][JRException]: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error [CompiladorJasper][jasperArrayListWeb][IOException]: " + e.getMessage());
        }
        FacesContext.getCurrentInstance().responseComplete();
        return ruta;
    }
    synchronized public void exportDiscoListPDF(ArrayList<JasperPrint> list, String nombreArchivo) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(Ruta.RUTA_DOWNLOAD + nombreArchivo);

            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING,
                    "UTF-8");
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT_LIST,
                    list);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
            exporter.exportReport();

            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control",
                    "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            response.setHeader("Content-Disposition", "attachment;filename=" + nombreArchivo + "");
            response.setContentType("text/pdf;charset=UTF-8");

            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
                    response.getOutputStream());

            exporter.exportReport();
            exporter.exportReport();

            fos.flush();
            fos.close();
        } catch (JRException e) {
            System.out.println("Error [CompiladorJasper][jasperArrayListWeb][JRException]: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error [CompiladorJasper][jasperArrayListWeb][IOException]: " + e.getMessage());
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    synchronized public void exportWebPDF(JasperPrint jasperPrint, String nombreArchivo) {
        ByteArrayOutputStream pdfReport = new ByteArrayOutputStream();
        try {
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRPdfExporterParameter.IS_ENCRYPTED, Boolean.TRUE);
            exporter.setParameter(JRPdfExporterParameter.OWNER_PASSWORD, "siga2005");
            exporter.setParameter(JRPdfExporterParameter.PERMISSIONS, new Integer(PdfWriter.ALLOW_PRINTING));
            exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, pdfReport);
            exporter.exportReport();

            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "attachment; filename=\"" + nombreArchivo + ".pdf\"");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "No-cache");
            response.setDateHeader("Expires", 0);
            //response.setContentLength(baos.size());

            ServletOutputStream outputStream = response.getOutputStream();

            outputStream.write(pdfReport.toByteArray());
            outputStream.close();
            //pdfReport.close();

        } catch (Exception e) {
            System.out.println("ERROR JasperUtil.createBytePDF: " + e.getMessage());
        }

        FacesContext.getCurrentInstance().responseComplete();

    }

    synchronized public void exportWebListPDF(ArrayList<JasperPrint> jasperPrints, String nombreArchivo) {
        ByteArrayOutputStream pdfReport = new ByteArrayOutputStream();
        try {
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRPdfExporterParameter.IS_ENCRYPTED, Boolean.TRUE);
            exporter.setParameter(JRPdfExporterParameter.OWNER_PASSWORD, "siga2005");
            exporter.setParameter(JRPdfExporterParameter.PERMISSIONS, new Integer(PdfWriter.ALLOW_PRINTING));
            exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT_LIST, jasperPrints);
            exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, pdfReport);
            exporter.exportReport();

            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "attachment; filename=\"" + nombreArchivo + ".pdf\"");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "No-cache");
            response.setDateHeader("Expires", 0);
            //response.setContentLength(baos.size());

            ServletOutputStream outputStream = response.getOutputStream();

            outputStream.write(pdfReport.toByteArray());
            outputStream.close();
          //  pdfReport.close();
        } catch (Exception e) {
            System.out.println("ERROR JasperUtil.createBytePDF: " + e.getMessage());
            e.printStackTrace();
        }

        FacesContext.getCurrentInstance().responseComplete();
    }
}
