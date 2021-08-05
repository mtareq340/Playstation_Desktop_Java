/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Connection.Sql;
import entities.Bill;
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
public class billDao {
    
    Sql sql = new Sql();
    public void insertBill(Bill b)
{
    try { 
          String query="INSERT INTO Bill "
                  + "(`b_from`, `b_to`, `b_duration`,`b_price`,`b_date`,`total`)"
                  + "Values ('"+b.getBillFrom()+"','"+b.getBillTo()+"'"
                  + ",'"+b.getBillDuration()+"','"+b.getBillPrice()+"','"+b.getBillDate()+"','"+b.getTotal()+"')";
          sql.ExcuteUpdate(query);
         System.err.println(query);
      } catch (Exception e) 
      {
e.printStackTrace();      }

}
public List selectBill()
{ 
        List<Bill>bill=new ArrayList<>();
        try {
           String query="select * from Bill ORDER BY bill.b_id DESC";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int id=rs.getInt("b_id");
          String from=rs.getString("b_from");
          String to=rs.getString("b_to");
          String duration=rs.getString("b_duration");
          String price=rs.getString("b_price");
          String date=rs.getString("b_date");
          String total=rs.getString("total");
          Bill b = new Bill(id, from ,to ,duration ,price,date,total);
          bill.add(b);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return bill;
}

public List selectBillDate(String from ,String to)
{ 
        List<Bill>bill=new ArrayList<>();
        try {
           String query="select * from Bill where bill.b_date BETWEEN '"+from+"' and '"+to+"' ORDER BY bill.b_id DESC";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int id=rs.getInt("b_id");
          String strFrom=rs.getString("b_from");
          String strTo=rs.getString("b_to");
          String duration=rs.getString("b_duration");
          String price=rs.getString("b_price");
          String date=rs.getString("b_date");
          String total=rs.getString("total");
          Bill b = new Bill(id, strFrom ,strTo ,duration ,price,date,total);
          bill.add(b);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return bill;
}

public List selectBillCount()
{ 
        List<Bill>bill=new ArrayList<>();
        try {
           String query="select count(bill.b_id) as count from Bill";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int count=rs.getInt("count");
          Bill b = new Bill(count);
          bill.add(b);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return bill;
}

public List selectBillCountDate(String from ,String to)
{ 
        List<Bill>bill=new ArrayList<>();
        try {
           String query="select count(bill.b_id) as count from Bill where bill.b_date BETWEEN '"+from+"' and '"+to+"'";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int count=rs.getInt("count");
          Bill b = new Bill(count);
          bill.add(b);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return bill;
}


public List sumBill()
{ 
        List<Bill>bill=new ArrayList<>();
        try {
           String query="SELECT sum(bill.b_price) as sum FROM bill";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          String price=rs.getDouble("sum")+"";
           Bill b = new Bill(price);
           bill.add(b);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return bill;
}

public List sumBillDate(String from , String to)
{ 
        List<Bill>bill=new ArrayList<>();
        try {
           String query="SELECT sum(bill.b_price) as sum FROM bill where bill.b_date BETWEEN '"+from+"' and '"+to+"'";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          String price=rs.getDouble("sum")+"";
           Bill b = new Bill(price);
           bill.add(b);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return bill;
}

public int SelectMaxBillID() {
        
        String query="SELECT MAX(b_id) from bill  ";
         
         ResultSet rs =sql.ExcuteQuery(query);

         try {
             if(rs.next()) {
                 String s = rs.getString(1);
                 int max =Integer.parseInt(s);
                 
                 return max;
             } } catch (SQLException ex) {
         }
      
         sql.close();
          return 0;
    }

public List selectOneBill(String n)
{ 
        List<Bill>bill=new ArrayList<>();
        try {
           String query="select * from Bill where b_id = '"+n+"'";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int id=rs.getInt("b_id");
          String from=rs.getString("b_from");
          String to=rs.getString("b_to");
          String duration=rs.getString("b_duration");
          String price=rs.getString("b_price");
          String date=rs.getString("b_date");
          String total=rs.getString("total");
          Bill b = new Bill(id, from ,to ,duration ,price,date,total);
          bill.add(b);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return bill;
}

public void updateBill(Bill b)
    {
    try {  
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
          Date date = new Date();
          String currentDate = dateFormat.format(date);
                String query="Update Bill "
                        + "set b_from = '"+b.getBillFrom()+"' ,"
                        + "b_duration = '"+b.getBillDuration()+"' ,"
                        + "b_price = '"+b.getBillPrice()+"' ,"
                        + "b_date = '"+currentDate+"' ,"
                        + "b_to = '"+b.getBillTo()+"'"
                        + "where b_id="+b.getBillId()+" "  ;
        System.out.println(query);
            sql.ExcuteUpdate(query);
    } catch (Exception e) {
    e.printStackTrace();
    }
    }

public void deleteBill(Bill b)
    {
    try {
         String query="Delete from Bill "
                + "where b_id='"+b.getBillId()+"'";        
        sql.ExcuteUpdate(query);
        System.out.println(query);
    } catch (Exception e) {
    e.printStackTrace();
    }
    }

    public void truncateBill()
    {
    try {
         String query="delete from Bill";
        sql.ExcuteUpdate(query);
    } catch (Exception ex) {
        ex.printStackTrace();    
    }

    }



}
