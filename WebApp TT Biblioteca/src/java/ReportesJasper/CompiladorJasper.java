package ReportesJasper;

import java.io.Serializable;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Juan Delgado Robles
 */
public class CompiladorJasper implements Serializable{

    private final ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

    synchronized public JasperPrint jasperPrint(String jrxmlPath, HashMap parametros,JRDataSource dataSource) {
        JasperPrint print = null;
        try {
            print = JasperFillManager.fillReport(jasperReport(jrxmlPath), parametros, dataSource);
        } catch (JRException e) {
            System.out.println("Error [CompiladorJasper][jasperExportEmpty][JRException]: " + e.getMessage());
        }
        return print;
    }

    synchronized public JasperReport jasperReport(String jrxmlPath) {
        String rp = this.sc.getRealPath(jrxmlPath);
        JasperReport report = null;
        try {
            JasperCompileManager.compileReportToFile(rp);
            report = JasperCompileManager.compileReport(rp);
        } catch (JRException e) {
            System.out.println("Error [CompiladorJasper][jasperReport][JRException]: " + e.getMessage());
        }
        return report;
    }

}
