/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursoireport;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Marcos
 */
public class Tela {
    
    public static void main(String[] args){
        try {
            Connection conn = PostgresConnection.getInstace().getConexao();
            
            String japerFile = System.getProperty("user.dir")+"/report/relatorio1.jrxml";
            try {
                JasperReport jr = JasperCompileManager.compileReport(japerFile);
                JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
                JasperViewer.viewReport(jp);
            } catch (JRException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
