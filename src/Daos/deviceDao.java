/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Connection.Sql;
import entities.Device;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mostafa
 */
public class deviceDao {
    
        Sql sql = new Sql();
    public void insertDevice(Device d)
{
      try {
            
          String query="INSERT INTO device "
                  + "(`d_name`,`d_price`,`d_multi`)"
                  + "Values ('"+d.getDeviceName()+"','"+d.getDevicePrice()+"','"+d.getDevicemulti()+"')";
          sql.ExcuteUpdate(query);
          System.out.println(query);
      } catch (Exception e) 
      {
e.printStackTrace();      }

}

public List selectDevice()
{ 
        List<Device>device=new ArrayList<>();
        try {
           String query="select * from Device";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int id=rs.getInt("d_id");
          String name=rs.getString("d_name");
          String price=rs.getString("d_price");
          String multi=rs.getString("d_multi");
          Device d = new Device(id, name ,price,multi);
          device.add(d);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return device;
}
public List searchDevice(String n)
{ 
        List<Device>device=new ArrayList<>();
        try {
           String query="select * from device WHERE d_NAME LIKE '%"+n+"%'";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int id=rs.getInt("d_id");
          String name=rs.getString("d_name");
          String price=rs.getString("d_price");
           String multi=rs.getString("d_multi");
          Device d = new Device(id, name ,price,multi);
          device.add(d);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return device;
}




public void updateDevice(Device d)
    {
    try {    
                String query="Update Device "
                        + "set d_name = '"+d.getDeviceName()+"', "
                        + "d_price = '"+d.getDevicePrice()+"' ,"
                         + "d_multi = '"+d.getDevicemulti()+"' "
                        + "where d_id="+d.getDeviceId()+" "  ;
            sql.ExcuteUpdate(query);
    } catch (Exception e) {
    e.printStackTrace();
    }
    }

public void deleteDevice(Device d)
    {
    try {
         String query="Delete from Device "
                + "where d_id='"+d.getDeviceId()+"'";        
        sql.ExcuteUpdate(query);
    } catch (Exception e) {
    e.printStackTrace();
    }
    }

    public void truncateDevice()
    {
    try {
         String query="delete from Device";
        sql.ExcuteUpdate(query);
    } catch (Exception ex) {
        ex.printStackTrace();    
    }

    }

    public static void main(String[] args) {
        deviceDao devicedao=new deviceDao();
   //    List<Device> device=devicedao.searchDevice("Room 1");
     //   String strprice=device.get(0).getDevicePrice();
         List<Device> device =devicedao.selectDevice();
        System.out.println(device.get(1).getDevicemulti());
    }



}
