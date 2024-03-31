/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author THIS PC
 */

import java.sql.*;
public class addUsers {
    //connect
    private Connection connect(){
        String url = "jdbc:sqlserver://LAPTOP-VS8A1FBT\\SQLEXPRESS;databaseName=MyDatabase;user=sa;password=010203;encrypt=false;trustServerCertificate=true";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
            System.out.println("CONNECT NiCE! 🍓");
        }catch(SQLException e){
            System.out.println("ERROR CONNECT! 🤐");
            System.out.print(e.getMessage());
        }
        return conn;
}
    //add table users
    public void insertAdd(String Hoten, String Email, String SoDienThoai, String MatKhau){
        String sql = "INSERT INTO Users(Hoten, Email, SoDienThoai, MatKhau) VALUES(?,?,?,?)";
        try(Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, Hoten);
            pstmt.setString(2, Email);
            pstmt.setString(3, SoDienThoai);
            pstmt.setString(4, MatKhau);
            pstmt.executeUpdate();
            System.out.println("DO Add Nice!  😋");
        }catch(SQLException e){
            System.out.println("Error Add! 🍜");
        }
    }
    //run main
    public static void main(String[] args){
        addUsers add = new addUsers();
        add.connect();
        add.insertAdd("Luong Quang Hung", "hung1234@gmail.com", "0965234782", "hung123");
        add.insertAdd("Nguyen Van Binh", "binh1234@gmail.com", "0985234715", "binh123");
        add.insertAdd("Dang Van Dat", "dat1234@gmail.com", "0985764455", "dat123");
        add.insertAdd("Nguyen Van Long", "long1234@gmai.com", "0988557723", "long123");
        add.insertAdd("Hoang T T Huyen", "huyen1234@gmail.com", "0974741212", "huyen123");
        add.insertAdd("Tran Viet Binh", "binh1244@gmail.com", "0966336633", "binh1234");
        add.insertAdd("Nguyen Quoc Long", "long1144@gmail.com", "0988855522", "long1234");
    }
}

