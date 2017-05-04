/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.beans.Statement;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Database {
    
    private String dbuser= "root";
    private String dbpassword= "";
    private Statement stmt= null;
    private Connection con= null;
    private ResultSet rs= null;
    
    public Database(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost/oop game,dbuser, dbpassword");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  //  gada executeQuery
//    public ResultSet getData(String SQLString){
//        rs= stmt.executeQuery(SQLString);
//    }
    
}
