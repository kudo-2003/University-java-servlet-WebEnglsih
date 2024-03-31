import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SignInServlet", urlPatterns = {"/SignInServlet"})
public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Email = request.getParameter("Email");
        String MatKhau = request.getParameter("MatKhau");

        // Kết nối đến cơ sở dữ liệu và kiểm tra thông tin đăng nhập
        String url = "jdbc:sqlserver://LAPTOP-VS8A1FBT\\SQLEXPRESS;databaseName=MyDatabase;user=sa;password=010203;encrypt=false;trustServerCertificate=true";        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url);
            String sql = "SELECT * FROM Users WHERE Email = ? AND MatKhau = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, Email);
            statement.setString(2, MatKhau);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Đăng nhập thành công!");
                response.sendRedirect("SignInSuccess.html");
            } else {
                System.out.println("Đăng nhập thất bại!");
                response.sendRedirect("SignInFailure.html");
            }
            
        } catch (Exception e) {
            System.out.println("Kết nối thất bại");
            e.printStackTrace();
        }
    }
    
}
