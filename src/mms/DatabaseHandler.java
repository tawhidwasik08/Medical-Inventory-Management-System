
package mms;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DatabaseHandler {
    Connection connect = null;
    int current_C_id=0;
    int current_admin_id=0;
    
    public void connectDatabase(){
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mms","root","");
            //System.out.println("Successfully Connected to Mysql");

        }catch(Exception e){
            System.out.println("Not Connected..");
            e.printStackTrace();
        }
    }
    
    
  
    
    public void registerAdmin(String name,String phone,String e_mail,String user_name,String password){
        try{
            String query = "INSERT INTO admin (name,user_name,password) values(?,?,?)";
            PreparedStatement pStatement = connect.prepareStatement(query);
            pStatement.setString(1, name);
            pStatement.setString(2, user_name);
            pStatement.setString(3, password);
           
            pStatement.executeUpdate();
            
            System.out.println("Successfully Registered..");
            
            
        }catch(Exception e){
            System.out.println("Error in registering");
            e.printStackTrace();
        }
        
    }
    
    public void signUpCustomer(String name,String phone,String address,String user_name,String password){
        try{
            String query = "INSERT INTO customer (name,phone,e_mail,user_name,password) values(?,?,?,?,?)";
            PreparedStatement pStatement = connect.prepareStatement(query);
            pStatement.setString(1, name);
            pStatement.setString(2, phone);
            pStatement.setString(3, address);
            pStatement.setString(4, user_name);
            pStatement.setString(5, password);
           
            pStatement.executeUpdate();
            
            System.out.println("Successfully signed up..");
            
            
        }catch(Exception e){
            System.out.println("Error in sign up");
            e.printStackTrace();
        }
        
    }
    
     
    public void loginAdmin(String user_name,String password){
        ResultSet resultSet = null;
        try{
            String query = "SELECT * FROM admin WHERE user_name =? and password =?";
            Statement statement ;
            PreparedStatement pStatement = connect.prepareStatement(query);
            pStatement.setString(1, user_name);
            pStatement.setString(2,password);
            resultSet = pStatement.executeQuery();
            
            if(resultSet.next()){
                
                int current_admin_id = resultSet.getInt("admin_id");
                JOptionPane.showMessageDialog(null,"Admin Logged in:"+current_admin_id,"LOG IN",JOptionPane.INFORMATION_MESSAGE);
                AdminMenuView v=new AdminMenuView(current_C_id);
                v.setVisible(true);
                
            }else{
                JOptionPane.showMessageDialog(null,"Log in failed","LOG IN",JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(Exception e){
            System.out.println("Error in Query..");
            e.printStackTrace();
            
        }
        
    }
    
    
    public void loginCustomer(String u_name,String pass){
        ResultSet resultSet = null;
        try{
            String query = "SELECT * FROM customer WHERE user_name =? and password =?";
            Statement statement ;
            PreparedStatement pStatement = connect.prepareStatement(query);
            pStatement.setString(1, u_name);
            pStatement.setString(2,pass);
            resultSet = pStatement.executeQuery();
            
            if(resultSet.next()){
               
                int current_C_id = resultSet.getInt("c_id");
                JOptionPane.showMessageDialog(null,"Customer Logged in:"+current_C_id,"LOG IN",JOptionPane.INFORMATION_MESSAGE);
                CustomerMenuView v=new CustomerMenuView(current_C_id);
                
                v.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Log in failed","LOG IN",JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(Exception e){
            System.out.println("Error in Query..");
            e.printStackTrace();
            
        }
        
    }
    
    
    
    
    
    //Storing MEDICINE LIST in ARRAY LIST
    public ArrayList<Medicine> customerMedList(int mode_check) {

        ArrayList<Medicine> medList = new ArrayList<>();
        ResultSet rs = null;

        try {
            String query = "SELECT *FROM medicine";
            if (mode_check == 1) 
                query = "SELECT *FROM medicine ORDER BY name DESC";
            if (mode_check == 2) 
                query = "SELECT *FROM medicine ORDER BY name ASC";
            if (mode_check == 3) 
                query = "SELECT *FROM medicine ORDER BY price DESC";
            if (mode_check == 4) 
                query = "SELECT *FROM medicine ORDER BY price ASC";
            
            Statement statement;
            statement = connect.createStatement();
            rs = statement.executeQuery(query);

            Medicine med;
            while (rs.next()) {
                med = new Medicine(rs.getInt("med_id"), rs.getString("name"), rs.getFloat("price"), rs.getInt("avl_quantity"));
                medList.add(med);
            }

            //System.out.println("Successfully Done Query..");
        } catch (Exception e) {
            //System.out.println("Error in QueryARRAy..");
            e.printStackTrace();
        }
        return medList;

    }
    
    
    
     public ArrayList<Stock> stockList(int mode_check){
         ArrayList<Stock> stockList=new ArrayList<>();
         ResultSet rs = null;
          try {
            String query = "SELECT stock.med_id,medicine.name,medicine.price,medicine.avl_quantity,stock.manf_name,stock.exp_date FROM stock JOIN medicine on stock.med_id = medicine.med_id";
            /*if (mode_check == 2) {
                query = "SELECT *FROM Stock ORDER BY price ASC";
            }*/
            Statement statement;
            statement = connect.createStatement();
            rs = statement.executeQuery(query);

            Stock stk;
            while (rs.next()) {
                stk = new Stock(rs.getInt("med_id"),rs.getString("name"),rs.getFloat("price"), rs.getInt("avl_quantity"),rs.getString("manf_name"),rs.getString("exp_date"));
                stockList.add(stk);
                
            }

            //System.out.println("Successfully Done Query..");
        } catch (Exception e) {
            //System.out.println("Error in QueryARRAy..");
            e.printStackTrace();
        }
         
         return stockList;
     }
    
    
     public ArrayList<Employee> empList(int mode_check){
         ArrayList<Employee> empList=new ArrayList<>();
         ResultSet rs = null;
          try {
            String query = "SELECT * FROM employee";
            /*if (mode_check == 2) {
                query = "SELECT *FROM Stock ORDER BY price ASC";
            }*/
            Statement statement;
            statement = connect.createStatement();
            rs = statement.executeQuery(query);

            Employee emp;
            while (rs.next()) {
                emp = new Employee(rs.getInt("e_id"),rs.getString("name"),rs.getString("phone"),rs.getString("address"),rs.getString("user_name"),rs.getString("password"));
                empList.add(emp);
                
            }

            //System.out.println("Successfully Done Query employee show..");
        } catch (Exception e) {
            //System.out.println("Error in QueryARRAy..");
            e.printStackTrace();
        }
         
         return empList;
     }
    
     
     
     public ArrayList<DetailOrder> orderList(int mode_check){
        ArrayList<DetailOrder> orderList=new ArrayList<>();
         ResultSet rs = null;
          try {
            String query = "SELECT * FROM order_info";
            /*if (mode_check == 2) {
                query = "SELECT *FROM Stock ORDER BY price ASC";
            }*/
            Statement statement;
            statement = connect.createStatement();
            rs = statement.executeQuery(query);

           DetailOrder order;
            while (rs.next()) {
                String processed="NO";
                if(rs.getInt("order_prcsd")==1){
                    processed="YES";
                }
               order = new DetailOrder(rs.getInt("order_no"),rs.getInt("c_id"),rs.getString("order_time"),rs.getFloat("order_val"),processed);
               orderList.add(order);
                
            }

            //System.out.println("Successfully Done Query employee show..");
        } catch (Exception e) {
            //System.out.println("Error in QueryARRAy..");
            e.printStackTrace();
        }
         
         return orderList;
     }
    
     
     
     
     
     public void insertMedicine(int id,String name,float price,int qty,String mafName,String date){
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        try{
            String query = "INSERT INTO medicine(med_id,name,price,avl_quantity) values(?,?,?,?)";
            String query2 = "INSERT INTO stock(med_id,manf_name,exp_date) values(?,?,?)";
            //Statement statement ;
            PreparedStatement pStatement = connect.prepareStatement(query);
            PreparedStatement p2Statement = connect.prepareStatement(query2);
            pStatement.setInt(1,id);
            pStatement.setString(2,name);
            pStatement.setFloat(3,price);
            pStatement.setInt(4,qty);
            pStatement.executeUpdate();
            
            p2Statement.setInt(1,id);
            p2Statement.setString(2,mafName);
            p2Statement.setString(3,date);
            p2Statement.executeUpdate();
            
            
           JOptionPane.showMessageDialog(null,"Medicine Added:"+name,"INSERT",JOptionPane.INFORMATION_MESSAGE);
            
            
        }catch(Exception e){
            System.out.println("Error in Query..");
            e.printStackTrace();
            
        }
        
    }
     
     
     
      public void insertEmployee(int id,String name,String phone,String address,String uName,String pass){
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        try{
            String query = "INSERT INTO employee(e_id,name,phone,address,user_name,password) values(?,?,?,?,?,?)";
            PreparedStatement pStatement = connect.prepareStatement(query);
            pStatement.setInt(1,id);
            pStatement.setString(2,name);
            pStatement.setString(3,phone);
            pStatement.setString(4,address);
            pStatement.setString(5,uName);
            pStatement.setString(6,pass);
            
            pStatement.executeUpdate();
            
            
           JOptionPane.showMessageDialog(null,"Employee Added:"+name,"INSERT",JOptionPane.INFORMATION_MESSAGE);
            
            
        }catch(Exception e){
            System.out.println("Error in Query..");
            e.printStackTrace();
            
        }
        
    }
     
     
    
}
