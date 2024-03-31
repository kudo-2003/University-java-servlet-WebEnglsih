import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "NavHomeServlet", urlPatterns = {"/NavHomeServlet"})
public class NavHomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Kết nối đến cơ sở dữ liệu và lấy dữ liệu
        String url = "jdbc:sqlserver://LAPTOP-VS8A1FBT\\SQLEXPRESS;databaseName=MyDatabase;user=sa;password=010203;encrypt=false;trustServerCertificate=true";
        List<String> navItems = new ArrayList<>();
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url);
            String sql = "SELECT NoiDungNav FROM NavHome";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                navItems.add(resultSet.getString("NoiDungNav"));
            }
            
            // Đặt navItems như một thuộc tính của yêu cầu
            request.setAttribute("navItems", navItems);
            request.getRequestDispatcher("/HomeEnglish.jsp").forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Kết nối cơ sở dữ liệu thất bại", e);
        }
    }
}
