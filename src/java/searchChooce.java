/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author THIS PC
 */

import java.sql.*;
public class searchChooce {
    private Connection connect(){
        String url = "jdbc:sqlserver://LAPTOP-VS8A1FBT\\SQLEXPRESS;databaseName=MyDatabase;user=sa;password=010203;encrypt=false;trustServerCertificate=true";        
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
            System.out.println("Connecting Good! 🐗");
        }catch(SQLException e){
            System.out.println("Error Conneting! 🥦");
            System.out.print("Error " + e.getMessage());
        }
        return conn;
    }
    
    public void searchChooce(String columnName, String value){
        String sql = "SELECT * FROM Users WHERE " + columnName + " = ?";
        try(Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, value);
            ResultSet rs = pstmt.executeQuery();
            if(!rs.next()){
                System.out.println("Not Found! 😥");
            }else{
                do{
                    System.out.println(rs.getString("Hoten") + "\t\t" + 
                                        rs.getString("Email") + "\t\t" + 
                                        rs.getString("SoDienThoai") + "\t\t" +
                                        rs.getString("MatKhau"));
                }while(rs.next());
            }
            System.out.println("End Table! 🍋");
        }catch(SQLException e){
            System.out.println("Error Next😡 => ");
            System.out.println(e.getMessage());
        }
    }
    public void search(String Hoten) {
    String sql = "SELECT * FROM Users WHERE Hoten = ?";
    try (Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, Hoten);
        ResultSet rs = pstmt.executeQuery();

        // Check if there are any results
        if (!rs.next()) {
            System.out.println("Không tìm thấy");
        } else {
            do {
                System.out.println(rs.getString("Hoten") + "\t" + 
                                   rs.getString("Email") + "\t" +
                                   rs.getString("SoDienThoai") + "\t" +
                                   rs.getString("MatKhau"));
            } while (rs.next());
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
    
    public void search_password(String Hoten, String Email, String SoDienThoai) {
    String sql = "SELECT * FROM Users WHERE Hoten = ? AND Email = ? AND SoDienThoai = ?";
    try (Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, Hoten);
        pstmt.setString(2, Email);
        pstmt.setString(3, SoDienThoai);
        ResultSet rs = pstmt.executeQuery();

        // Check if there are any results
        if (!rs.next()) {
            System.out.println("Không tìm thấy");
        } else {
            do {
                System.out.println(rs.getString("Hoten") + "\t" + 
                                   rs.getString("Email") + "\t" +
                                   rs.getString("SoDienThoai") + "\t" +
                                   rs.getString("MatKhau"));
            } while (rs.next());
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
    
    public static void main(String[] args) {        String url = "jdbc:sqlserver://LAPTOP-VS8A1FBT\\SQLEXPRESS;databaseName=MyDatabase;user=sa;password=010203;encrypt=false;trustServerCertificate=true";        

        searchChooce searchName = new searchChooce();
        System.out.println("****************************");
        searchName.searchChooce("Email", "binh1234@gmail.com");
        System.out.println("*****************************");
        searchName.searchChooce("MatKhau", "long123");
    }
}
