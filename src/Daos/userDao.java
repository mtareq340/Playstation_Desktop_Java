/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Connection.Sql;
import entities.Bill;
import entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mostafa
 */
public class userDao {
    
    Sql sql = new Sql();
    public void insertUser(User u)
{
    try { 
          String query="INSERT INTO Users "
                    + "(`u_name`, `u_password`, `u_role`)"
                  + "Values ('"+u.getUserName()+"','"+u.getUserPassword()+"','"+u.getUserRole()+"')";
          sql.ExcuteUpdate(query);
         System.err.println(query);
      } catch (Exception e) 
      {
e.printStackTrace();      }

}
public List selectUser()
{ 
        List<User>user=new ArrayList<>();
        try {
           String query="select * from users";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int id = rs.getInt("u_id");
          String name = rs.getString("u_name");
          String password = rs.getString("u_password");
          String role = rs.getString("u_role");
          User u = new User(id, name ,password ,role);
          user.add(u);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return user;
}

public void updateUser(User u)
    {
    try {  
                String query="Update Users "
                        + "set u_name = '"+u.getUserName()+"' ,"
                        + "u_password = '"+u.getUserPassword()+"' ,"
                        + "u_role = '"+u.getUserRole()+"'"
                        + "where u_id="+u.getUserId()+" "  ;
            sql.ExcuteUpdate(query);
    } catch (Exception e) {
    e.printStackTrace();
    }
    }
 public void updateAdminPassword(String old_pass,String new_pass)
    {
    try {    
                String query="Update users "
                        + "set admin_password = '"+new_pass+"' "
                        + "where admin_password="+old_pass+" "  ;
        System.out.println(query);
            sql.ExcuteUpdate(query);
    } catch (Exception ex) {
    ex.printStackTrace();
    }
    }

public void deleteUser(User u)
    {
    try {
         String query="Delete from users "
                + "where u_id='"+u.getUserId()+"'";        
        sql.ExcuteUpdate(query);
        System.out.println(query);
    } catch (Exception e) {
    e.printStackTrace();
    }
    }

    public void truncateUser()
    {
    try {
         String query="delete from users";
        sql.ExcuteUpdate(query);
    } catch (Exception ex) {
        ex.printStackTrace();    
    }

    }



}
