import java.sql.*;
public class connetDBserverSQL {
    private Connection connect() {
        // SQL Server JDBC connection string
        String url = "jdbc:sqlserver://127.0.1:\\SQLEXPRESS;databaseName=MyDatabase;user=sa;password=010203;encrypt=false;trustServerCertificate=true";        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("ket noi thanh cong");
        } catch (SQLException e) {
            System.out.println("Ket noi that bai");
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    //add user 
    public void insert(String Hoten, String Email, String SoDienThoai, String MatKhau) {
        String sql = "INSERT INTO Users(Hoten, Email, SoDienThoai, MatKhau) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Hoten);
            pstmt.setString(2, Email);
            pstmt.setString(3, SoDienThoai);
            pstmt.setString(4, MatKhau);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Show table 
    public void select() {
    String sql = "SELECT * FROM Users";

    try (Connection conn = this.connect();
         Statement stmt  = conn.createStatement();
         ResultSet rs    = stmt.executeQuery(sql)){
        System.out.println("||||||||||||||||||||||||||||||||||");
        // loop through the result set
        while (rs.next()) {
            System.out.println(rs.getString("Hoten") + "\t" + 
                               rs.getString("Email") + "\t" +
                               rs.getString("SoDienThoai") + "\t" +
                               rs.getString("MatKhau"));
        }
        System.out.println("||||||||||||||||||||||||||||||||||");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
    //updete users
    public void update(String Hoten, String Email, String SoDienThoai, String MatKhau, String UpdateUser) {
        String sql = "UPDATE Users SET Hoten = ?, Email = ?, SoDienThoai = ?, MatKhau = ? WHERE SoDienThoai = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Hoten);
            pstmt.setString(2, Email);
            pstmt.setString(3, SoDienThoai);
            pstmt.setString(4, MatKhau);
            pstmt.setString(5, UpdateUser);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // delate hoten
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
            System.out.println("no khong ton tai");
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
    
public void deleteAll() {
    String sql = "DELETE FROM Users";

    try (Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.executeUpdate();
        System.out.println("Đã xóa thành công tất cả dữ liệu trong bảng Users");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}


    public void search_All(String columnName, String value) {
    String sql = "SELECT * FROM Users WHERE " + columnName + " = ?";
    try (Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, value);
        ResultSet rs = pstmt.executeQuery();

        // Check if there are any results
        if (!rs.next()) {
            System.out.println("not found😐 ");
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

    public static void main(String[] args) {
    connetDBserverSQL app = new connetDBserverSQL();
//    app.insert("Nguyen Van A", "nguyenvana@example.com", "0123456789", "securePassword");
//    app.update("Lương Quang Hùng", "hung94079@donga.edu.vn", "0964404653", "XinChaoHung", "0964404653");
//   app.insert("Lê Vũ Trọng Đức", "duc95756@donga.edu.vn", "0988583777", "DucInLove");
//      app.insert("Đạt đẹp trai", "hung94079@donga.edu.vn", "0964404653", "ToiLaLuongQuangHung");

//app.select();
//app.search("Lương Quang Hùng");
//app.search_All("SoDienThoai", "0964404653");
//app.search_password("Đạt đẹp trai", "hung94079@donga.edu.vn", "0964404653");
//app.select();
//app.deleteAll();
//app.delete_SoDienThoai("9866552552");
app.select();
}

}
