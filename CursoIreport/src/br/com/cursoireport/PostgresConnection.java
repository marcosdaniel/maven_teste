/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursoireport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marcos
 */
public class PostgresConnection {
    
    public static PostgresConnection pc;
    public Connection conn;
    
    private String url = "jdbc:postgresql://localhost:5432/ireports";
    private String className = "org.postgresql:Driver";
    private String usuario = "postgres";
    private String senha = "postgre";
    
    public PostgresConnection(){
        
    }
    
    public static PostgresConnection getInstace(){
        if(pc == null){
            pc = new PostgresConnection();
        }
        return pc;
    }
    
    public  Connection getConexao() throws ClassNotFoundException, SQLException{
        Class.forName(className);
        conn = DriverManager.getConnection(url, usuario, senha);
        return conn;
    }
    
    
//    public Connection getConnection(){
//        try{
//            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/ireports", "postgres", "postgre");
//        }catch(SQLException e){
//            throw new RuntimeException(e);
//        }
//    }
    
}
