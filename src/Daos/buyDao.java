/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Connection.Sql;
import entities.Buy;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mostafa
 */
public class buyDao {
    
        Sql sql = new Sql();
    public void insertBuy(Buy bu)
{
      try {
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
          SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");  
          Date date = new Date();
          String currentDate = dateFormat.format(date);
          String currentTime = timeFormat.format(date);
          String query="INSERT INTO Buy "
                  + "(`bu_name`, `bu_price`, `bu_date`, `bu_time`)"
                  + "Values ('"+bu.getBuyName()+"'"
                  + ",'"+bu.getBuyPrice()+"','"+currentDate+"','"+currentTime+"')";
          sql.ExcuteUpdate(query);
          System.out.println(query);
      } catch (Exception e) 
      {
e.printStackTrace();      }

}
public List selectBuy()
{ 
        List<Buy>buy=new ArrayList<>();
        try {
           String query="select * from Buy";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int id=rs.getInt("bu_id");
          String name=rs.getString("bu_name");
          String price=rs.getString("bu_price");
          String date=rs.getString("bu_date");
          String time=rs.getString("bu_time");
          Buy b = new Buy(id, name, price,date,time);
          buy.add(b);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return buy;
}

public List selectBuyDate(String from , String to)
{ 
        List<Buy>buy=new ArrayList<>();
        try {
           String query="SELECT * FROM `buy` WHERE bu_date BETWEEN '"+from+"' and '"+to+"'";
            System.out.println(query);
           ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int id=rs.getInt("bu_id");
          String name=rs.getString("bu_name");
          String price=rs.getString("bu_price");
          String date=rs.getString("bu_date");
          String time=rs.getString("bu_time");
          Buy b = new Buy(id, name, price,date,time);
          buy.add(b);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return buy;
}

public List sumBuy()
{ 
        List<Buy>buy=new ArrayList<>();
        try {
           String query="SELECT sum(buy.bu_price) as sum FROM buy";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int sum=rs.getInt("sum");
          Buy b = new Buy(sum);
          buy.add(b);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return buy;
}

public List sumBuyDate(String from , String to)
{ 
        List<Buy>buy=new ArrayList<>();
        try {
            String query="SELECT sum(buy.bu_price) as sum FROM buy where buy.bu_date BETWEEN '"+from+"' and '"+to+"'";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int sum=rs.getInt("sum");
          Buy b = new Buy(sum);
          buy.add(b);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return buy;
}


public List searchBuy(String n)
{ 
        List<Buy>buy=new ArrayList<>();
        try {
           String query="select * from Buy WHERE bu_NAME LIKE '%"+n+"%'";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int id=rs.getInt("bu_id");
          String name=rs.getString("bu_name");
          String price=rs.getString("bu_price");
          String date=rs.getString("bu_date");
          String time=rs.getString("bu_time");
          Buy b = new Buy(id, name, price,date,time);
          buy.add(b);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return buy;
}

public void updateBuy(Buy bu)
    {
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
          SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");  
          Date date = new Date();
          String currentDate = dateFormat.format(date);
          String currentTime = timeFormat.format(date);
    try {    
                String query="Update Buy "
                        + "set bu_name = '"+bu.getBuyName()+"' ,"
                        + "bu_price = '"+bu.getBuyPrice()+"',"
                        + "bu_date = '"+currentDate+"',"
                        + "bu_time = '"+currentTime+"'"
                        + "where bu_id='"+bu.getBuyId()+"' "  ;
            sql.ExcuteUpdate(query);
    } catch (Exception e) {
    e.printStackTrace();
    }
    }

public void deleteBuy(Buy bu)
    {
    try {
         String query="Delete from Buy "
                + "where bu_id='"+bu.getBuyId()+"'";        
        sql.ExcuteUpdate(query);
    } catch (Exception e) {
    e.printStackTrace();
    }
    }

    public void truncateBuy()
    {
    try {
         String query="delete from Buy";
        sql.ExcuteUpdate(query);
    } catch (Exception ex) {
        ex.printStackTrace();    
    }

    }





}
