/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Connection.Sql;
import entities.Drink;
import entities.billDrink;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mostafa
 */
public class billDrinkDao {
    
        Sql sql = new Sql();
    public void insertBillDrink(billDrink bd)
{
      try {
            
          String query="INSERT INTO billDrink "
                  + "(`b_id`, `dr_id`)"
                  + "Values ('"+bd.getBillId()+"'"
                  + ",'"+bd.getDrinkId()+"')";
          sql.ExcuteUpdate(query);
          System.out.println(query);
      } catch (Exception e) 
      {
e.printStackTrace();      }

}

public List selectBillDrink()
{ 
        List<billDrink>billDrink=new ArrayList<>();
        try {
           String query="select * from billDrink";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int id=rs.getInt("bd_id");
          int billId=rs.getInt("b_id");
          int drinkId=rs.getInt("dr_id");
          billDrink bd = new billDrink(id, billId, drinkId);
          billDrink.add(bd);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return billDrink;
}

public List countBillDrink(String n)
{ 
        List<billDrink>billDrink=new ArrayList<>();
        try {
           String query="SELECT count(billdrink.b_id) as count FROM `billdrink` WHERE dr_id = '"+n+"'";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int count=rs.getInt("count");
          billDrink bd = new billDrink(count);
          billDrink.add(bd);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return billDrink;
}

public List countBillDrinkDate(String from,String to,String n)
{ 
        List<billDrink>billDrink=new ArrayList<>();
        try {
           String query="SELECT count(billdrink.b_id) as count FROM `billdrink` , bill "
                   + "where billdrink.b_id = bill.b_id and bill.b_date BETWEEN '"+from+"' and '"+to+"' and dr_id = "+n+"";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int count=rs.getInt("count");
          billDrink bd = new billDrink(count);
          billDrink.add(bd);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return billDrink;
}

public List sumBillDrink()
{ 
        List<billDrink>billDrink=new ArrayList<>();
        try {
           String query="SELECT sum(drink.dr_price) as sum FROM billdrink,drink where billdrink.dr_id = drink.dr_id";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int sum=rs.getInt("sum");
          billDrink bd = new billDrink(sum);
          billDrink.add(bd);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return billDrink;
}

public List sumBillDrinkDate(String from ,String to)
{ 
        List<billDrink>billDrink=new ArrayList<>();
        try {
           String query="SELECT sum(drink.dr_price) as sum "
                        + "FROM billdrink,drink,bill "
                        + "where billdrink.dr_id = drink.dr_id and bill.b_id = billdrink.b_id and bill.b_date BETWEEN '"+from+"' and '"+to+"'";
                 ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int sum=rs.getInt("sum");
          billDrink bd = new billDrink(sum);
          billDrink.add(bd);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return billDrink;
}




public int SelectMaxDrinkID() {
        
        String query="SELECT MAX(b_id) from billdrink  ";
         
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

public List selectOneBillDrinkBillId(String n)
{ 
        List<billDrink>billDrink=new ArrayList<>();
        try {
           String query="select * from billDrink WHERE b_id = '"+n+"'";
           ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int id=rs.getInt("bd_id");
          int billId=rs.getInt("b_id");
          int drinkId=rs.getInt("dr_id");
          billDrink bd = new billDrink(id, billId, drinkId);
          billDrink.add(bd);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return billDrink;
}


public void updateBillDrink(billDrink bd)
    {
    try {    
                String query="Update billDrink "
                        + "set b_id = '"+bd.getBillId()+"' ,"
                        + "dr_id = '"+bd.getDrinkId()+"'"
                        + "where bd_id="+bd.getBillDrinkID()+" "  ;
        System.out.println(query);
            sql.ExcuteUpdate(query);
    } catch (Exception e) {
    e.printStackTrace();
    }
    }

public void deleteBillDrink(billDrink bd)
    {
    try {
         String query="Delete from billDrink "
                + "where bd_id='"+bd.getBillDrinkID()+"'";        
        sql.ExcuteUpdate(query);
    } catch (Exception e) {
    e.printStackTrace();
    }
    }

    public void truncateBillDrink()
    {
    try {
         String query="delete from billDrink";
        sql.ExcuteUpdate(query);
    } catch (Exception ex) {
        ex.printStackTrace();    
    }

    }



}
