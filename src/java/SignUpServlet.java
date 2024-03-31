import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Hoten = request.getParameter("Hoten");
        String Email = request.getParameter("Email");
        String SoDienThoai = request.getParameter("SoDienThoai");
        String MatKhau = request.getParameter("MatKhau");

        // Kết nối đến cơ sở dữ liệu và lưu thông tin đăng ký
        String url = "jdbc:sqlserver://LAPTOP-VS8A1FBT\\SQLEXPRESS;databaseName=MyDatabase;user=sa;password=010203;encrypt=false;trustServerCertificate=true";        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url);
            String sql = "INSERT INTO Users(Hoten, Email, SoDienThoai, MatKhau) VALUES(?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, Hoten);
            statement.setString(2, Email);
            statement.setString(3, SoDienThoai);
            statement.setString(4, MatKhau);
            int rowsInserted = statement.executeUpdate();
            System.out.println("Ket noi Thanh cong");
            if (rowsInserted > 0) {
                System.out.println("Sign Up successfully!");
                response.sendRedirect("SignUpSuccess.html");
            }else{
                System.out.println("Sign Up Failure");
                response.sendRedirect("SignUpFailure.html");
            }
        } catch (Exception e) {
            System.out.println("Error conneting ");
            e.printStackTrace();
        }
    }
    
}
