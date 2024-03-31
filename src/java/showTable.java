/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author THIS PC
 */

import java.sql.*;

public class showTable {
    private Connection connect() {
        String url = "jdbc:sqlserver://LAPTOP-VS8A1FBT\\SQLEXPRESS;databaseName=MyDatabase;user=sa;password=010203;encrypt=false;trustServerCertificate=true";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
            System.out.println("Connect GO! 😍");
        }catch(SQLException e){
            System.out.println("Error SQL! 🍌");
            System.out.println("Yeu Cau Sua Loi " + e.getMessage());
        }
        return conn;
    }
    
    public void selectShow(){
        String sql = "SELECT * FROM Users";
        try(Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            System.out.println("Show Table Good! 💢");
            System.out.println("*******************************************************************");
            while(rs.next()){
                System.out.println(rs.getString("Hoten") + "\t\t" +
                                    rs.getString("Email") + "\t\t" + 
                                    rs.getString("SoDienThoai") + "\t\t" + 
                                    rs.getString("MatKhau"));
            }
            System.out.println("*******************************************************************");
            System.out.println("End Table! 👲");
        }catch(SQLException e){
            System.out.println("ERROR TO DO! 😨");
            System.out.println("Giai Loi " + e.getMessage());
        }
    }
    
    public static void main(String[] args){
        showTable show = new showTable();
        show.selectShow();
    }
}
