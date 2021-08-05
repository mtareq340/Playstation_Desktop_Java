/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mostafa
 */
public class Sql {
    
    Connection con ;
    Statement stmt ;
    public Sql() {

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "ps"
                  + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&characterEncoding=UTF-8"
                    + "&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            stmt = con.createStatement();
            
        } catch (Exception ex) {        
            //getMessage() ÈÊÌÈáì ÑÓÇáå ÈÇáÇßÓÈÔä Çááì ÍÕá ÈÇáÙÈØ
            System.out.println(ex.getMessage());    
 
     }
    }

    public void close()
    {
    try {
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public ResultSet ExcuteQuery(String query)
    {
        try {
            return stmt.executeQuery(query);
        } catch (Exception e) {
        }
        return null;
}
    public void ExcuteUpdate(String query)
    {
        try {
            stmt.executeUpdate(query);
        } catch (Exception e) {
        }
    }

}
