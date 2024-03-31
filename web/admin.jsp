

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin 🥩</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="public/css/AdminAdd.css">
    </head>
    <body>
        <h1 class="center">Table Sign UP Users😊</h1>
<%@ page import="java.sql.*" %>
<%
    // Kết nối đến cơ sở dữ liệu
    String url = "jdbc:sqlserver://LAPTOP-VS8A1FBT\\SQLEXPRESS;databaseName=MyDatabase;user=sa;password=010203;encrypt=false;trustServerCertificate=true";
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    Connection conn = DriverManager.getConnection(url);
    String sql = "";
    PreparedStatement statement;
    ResultSet resultSet;

    // Xử lý yêu cầu thêm, sửa, xóa
    String action = request.getParameter("action");
    if (action != null) {
        if (action.equals("add")) {
            String hoten = request.getParameter("Hoten");
            String email = request.getParameter("Email");
            String sodienthoai = request.getParameter("SoDienThoai");
            String matkhau = request.getParameter("MatKhau");
            if (hoten != null && !hoten.isEmpty() && email != null && !email.isEmpty() && sodienthoai != null && !sodienthoai.isEmpty() && matkhau != null && !matkhau.isEmpty()) {
                sql = "INSERT INTO Users(Hoten, Email, SoDienThoai, MatKhau) VALUES(?,?,?,?)";
                statement = conn.prepareStatement(sql);
                statement.setString(1, hoten);
                statement.setString(2, email);
                statement.setString(3, sodienthoai);
                statement.setString(4, matkhau);
                statement.executeUpdate();
            }
        } else if (action.equals("edit")) {
            // Các hành động sửa và xóa tương tự như trên
        }
    }

    // Lấy dữ liệu từ bảng Users
    sql = "SELECT * FROM Users";
    statement = conn.prepareStatement(sql);
    resultSet = statement.executeQuery();

    // Hiển thị dữ liệu
    out.println("<style>");
    out.println("table, th, td {");
    out.println("  border: 1px solid black;");
    out.println("  border-collapse: collapse;");
    out.println("}");
    out.println("</style>");
    out.println("<table>");
    out.println("<tr><th>Số thứ tự</th><th>Họ tên</th><th>Email</th><th>Số điện thoại</th><th>Mật khẩu</th><th></th><th></th><th></th></tr>");
    int count = 1;
    while (resultSet.next()) {
        out.println("<form method=\"post\">");
        out.println("<tr>");
        out.println("<td>" + count + "</td>");
        out.println("<td><input type=\"text\" name=\"Hoten\" value=\"" + resultSet.getString("Hoten") + "\" /></td>");
        out.println("<td><input type=\"text\" name=\"Email\" value=\"" + resultSet.getString("Email") + "\" /></td>");
        out.println("<td><input type=\"text\" name=\"SoDienThoai\" value=\"" + resultSet.getString("SoDienThoai") + "\" /></td>");
        out.println("<td><input type=\"text\" name=\"MatKhau\" value=\"" + resultSet.getString("MatKhau") + "\" /></td>");
        out.println("<td><input type=\"submit\" name=\"action\" value=\"Edit\" /></td>");
        out.println("<td><input type=\"submit\" name=\"action\" value=\"Delete\" /></td>");
        out.println("</tr>");
        out.println("</form>");
        count++;
    }
    out.println("</table>");

    // Đóng kết nối
    conn.close();
%>

<div class="container text-center">
  <div class="row">
    <div class="col">
      <div class="center">
  <h1>Add User Here !😀</h1>
  <form method="post">
    <div class="inputbox">
        <input type="text" name="Hoten" required="required">
      <span>Name</span>
    </div>
    <div class="inputbox">
        <input type="text" name="Email" required="required">
      <span>Email</span>
    </div>
      <div class="inputbox">
        <input type="text" name="SoDienThoai" required="required">
      <span>Phone</span>
    </div>
      <div class="inputbox">
        <input type="text" name="MatKhau" required="required">
      <span>Password</span>
    </div>
    <div class="inputbox">
        <input type="submit" name="action" value="add">
    </div>
  </form>
</div>
    </div>
    <div class="col">
      <div class="center">
  <h1>Add User Edit !😀</h1>
  <form method="post">
    <div class="inputbox">
        <input type="text" name="Hoten" required="required">
      <span>Name</span>
    </div>
    <div class="inputbox">
        <input type="text" name="Email" required="required">
      <span>Email</span>
    </div>
      <div class="inputbox">
        <input type="text" name="SoDienThoai" required="required">
      <span>Phone</span>
    </div>
      <div class="inputbox">
        <input type="text" name="MatKhau" required="required">
      <span>Password</span>
    </div>
    <div class="inputbox">
        <input type="submit" name="action" value="add">
    </div>
  </form>
</div>
    </div>
    <div class="col">
      <div class="p-3 text-primary-emphasis bg-primary-subtle border border-primary-subtle rounded-3">
  Note: Add, Update, Search and delete 
  Do it your way. 😄
    </div>
    </div>
  </div>
</div>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>

