/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author THIS PC
 */
import java.sql.*;

public class editUsers {
    private Connection connect(){
        String url = "jdbc:sqlserver://LAPTOP-VS8A1FBT\\SQLEXPRESS;databaseName=MyDatabase;user=sa;password=010203;encrypt=false;trustServerCertificate=true";        
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
            System.out.println("Connction successful!");
        }catch(SQLException e){
            System.out.println("Connection failed!");
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void UpdateUser(String Hoten, String Email, String SoDienThoai, String MatKhau, String UpdateUser){
        String sql = "UPDATE Users SET Hoten = ?, Email = ?, SoDienThoai = ?, MatKhau = ? WHERE SoDienThoai = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, Hoten);
            pstmt.setString(2, Email);
            pstmt.setString(3, SoDienThoai);
            pstmt.setString(4, MatKhau);
            pstmt.setString(5, UpdateUser);
            pstmt.executeUpdate();
            System.out.println("Updete good!🛩");
        }catch(SQLException e){
            System.out.println("Error 🚀");
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        editUsers edit = new editUsers();
        edit.connect();
        edit.UpdateUser("Hung Dep Trai", "hung8888@gmail.com", "096440465", "hung8888", "0985764455");
    }
}
