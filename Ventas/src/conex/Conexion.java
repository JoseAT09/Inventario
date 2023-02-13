/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conex;

import java.sql.*;
import com.mysql.jdbc.Driver;

/**
 *
 * @author josea
 */
public class Conexion {

    private Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/Inventario", "root", "");
        } catch (Exception e) {
            System.out.println("EFE: " + e);
        }
    }
    
    public Connection getConnection(){
        return con;
    }
}
