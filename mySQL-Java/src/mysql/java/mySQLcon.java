package mysql.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mySQLcon {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String mysqlURL = "jdbc:mysql://localhost:3306/world?autoReconnect=true&useSSL=false";
            Connection conexion = DriverManager.getConnection(mysqlURL, "root", "pass");
            
            Statement myStatement = conexion.createStatement();
            
            long inicio = (System.currentTimeMillis());
            System.out.println(inicio);
            ResultSet result = myStatement.executeQuery("SELECT * FROM city limit 10");
            long fin = (System.currentTimeMillis());
            System.out.println(fin);
            System.out.println(fin - inicio);
            
            
            int ID;
            String Name;
            while(result.next()){
                ID = result.getInt("Id");
                Name = result.getString("Name");
                System.out.println("Ciudad " + ID + " -- Nombre: " + Name);
            }
           
            

            conexion.close();

        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando driver: " + ex);
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex);
        }
        
        
    }
    
}
