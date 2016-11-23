/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinare.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author mauricio.rosito
 */
public class ConnectionFactory {
    
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost/aluno_vaccinare";
    private static final String username = "aluno";
    private static final String password = "aluno";
     
    private static Connection conn=null;
    
    public static Connection getConnection(){
       try {
           // Este é um dos meios para registrar um driver 
            Class.forName(driverName);
            // Registrado o driver, vamos estabelecer uma conexão 
            conn = DriverManager.getConnection(url, username, password);
 
        } catch (ClassNotFoundException | SQLException e) {
            // Erros no acesso ao banco
            Logger.getLogger(vaccinare.Vaccinare.class.getName()).log(Level.SEVERE, null, e);
        }
        return conn;
    }
    
    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        close(conn, stmt, rs);
    }
 
    public static void closeConnection(Connection conn, Statement stmt) throws Exception {
        close(conn, stmt, null);
    }
 
    public static void closeConnection(Connection conn) throws Exception {
        close(conn, null, null);
    }
 
    private static void close(Connection conn, Statement stmt, ResultSet rs) 
            throws Exception {
        try {
            if (rs != null) rs.close( );
            if (stmt != null)stmt.close( );
            if (conn != null)conn.close( );
        } catch (Exception e) {
            throw new Exception(e.getMessage( ));
        }
    }       
     
}