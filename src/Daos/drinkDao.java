/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Connection.Sql;
import entities.Drink;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mostafa
 */
public class drinkDao {
    
    Sql sql = new Sql();
    public void insertDrink(Drink d)
{
      try {
            
          String query="INSERT INTO Drink "
                  + "(`dr_name`, `dr_price`)"
                  + "Values ('"+d.getDrinkName()+"'"
                  + ",'"+d.getDrinkPrice()+"')";
          sql.ExcuteUpdate(query);
      } catch (Exception e) 
      {
e.printStackTrace();      }

}

public List selectDrink()
{ 
        List<Drink>drink=new ArrayList<>();
        try {
           String query="select * from Drink";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int id=rs.getInt("dr_id");
          String name=rs.getString("dr_name");
          String price=rs.getString("dr_price");
          Drink d = new Drink(id, name, price);
          drink.add(d);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return drink;
}

public List searchDrink(String n)
{ 
        List<Drink>drink=new ArrayList<>();
        try {
           String query="select * from Drink WHERE dr_NAME LIKE '%"+n+"%'";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int id=rs.getInt("dr_id");
          String name=rs.getString("dr_name");
          String price=rs.getString("dr_price");
          Drink d = new Drink(id, name, price);
          drink.add(d);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return drink;
}

public List selectOneDrink(String n)
{ 
        List<Drink>drink=new ArrayList<>();
        try {
           String query="select * from Drink WHERE dr_id = '"+n+"'";
            ResultSet rs =sql.ExcuteQuery(query);
         while (rs.next())
          {
          int id=rs.getInt("dr_id");
          String name=rs.getString("dr_name");
          String price=rs.getString("dr_price");
          Drink d = new Drink(id, name, price);
          drink.add(d);
          }
          
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
      return drink;
}

public void updateDrink(Drink d)
    {
    try {    
                String query="Update Drink "
                        + "set dr_name = '"+d.getDrinkName()+"' ,"
                        + "dr_price = '"+d.getDrinkPrice()+"'"
                        + "where dr_id="+d.getDrinkId()+" "  ;
            sql.ExcuteUpdate(query);
    } catch (Exception e) {
    e.printStackTrace();
    }
    }

public void deleteDrink(Drink d)
    {
    try {
         String query="Delete from Drink "
                + "where dr_id='"+d.getDrinkId()+"'";        
        sql.ExcuteUpdate(query);
    } catch (Exception e) {
    e.printStackTrace();
    }
    }

    public void truncateDrink()
    {
    try {
         String query="delete from Drink";
        sql.ExcuteUpdate(query);
    } catch (Exception ex) {
        ex.printStackTrace();    
    }

    }

    public static void main(String[] args) {
        drinkDao dDao=new drinkDao();
        List<Drink> drink=dDao.searchDrink("moz");
            int drinkID=drink.get(0).getDrinkId();
            System.out.println(drinkID);
    }


}
