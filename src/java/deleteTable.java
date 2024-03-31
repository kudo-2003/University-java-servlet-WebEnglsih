/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author THIS PC
 */
import java.sql.*;
public class deleteTable {
    private Connection connect(){
        String url = "jdbc:sqlserver://LAPTOP-VS8A1FBT\\SQLEXPRESS;databaseName=MyDatabase;user=sa;password=010203;encrypt=false;trustServerCertificate=true";        
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
            System.out.println("CONNECT GOOD! 🍄");
        }catch (SQLException e){
            System.out.println("CONNECT ERROR! 🍅");
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void deleteAll(){
        String sql = "DELETE FROM Users";
        try(Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.executeUpdate();
            System.out.println("DELETE GOOD! 🌹");
        }catch(SQLException e){
            System.out.println("Error 🤒 ");
            System.out.println(e.getMessage());
        }
    }
    
    public void delete_Hoten(String Hoten) {
        String sql = "DELETE FROM Users WHERE Hoten = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Hoten);
            pstmt.executeUpdate();
            System.out.println("Da xoa thanh cong");
        } catch (SQLException e) {
            System.out.println("no khong ton tai");
            System.out.println(e.getMessage());
        }
    }
        //
        public void delete_SoDienThoai(String SoDienThoai) {
        String sql = "DELETE FROM Users WHERE SoDienThoai = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, SoDienThoai);
            pstmt.executeUpdate();
            System.out.println("Da xoa thanh cong");
        } catch (SQLException e) {
            System.err.println("no khong ton tai");
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void main(String[] args){
        deleteTable xoaTatCa = new deleteTable();
        xoaTatCa.connect();
        xoaTatCa.deleteAll();
    }
}


