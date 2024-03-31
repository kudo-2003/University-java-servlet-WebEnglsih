<%-- 
    Document   : index
    Created on : 11 thg 1, 2024, 16:25:53
    Author     : THIS PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>English</title>
      <link rel="stylesheet" href="public/css/index.css"/>
    </head>
        <body>
        <div>
  <ul data-time="4000">
    <li data-hue="222" >E</li>
    <li data-hue="0" >N</li>
    <li data-hue="157" >G</li>
    <li data-hue="197" >L</li>
    <li data-hue="45" >I</li>
    <li data-hue="17" >S</li>
    <li data-hue="95" >H</li>
  </ul>
</div>
<canvas></canvas>
<script src="public/js/index.js"></script>
 <script >
            window.onload = function() {
                setTimeout(function() {
                    window.location.href = "SignIn.jsp"; }, 8000); 
            };
        </script>
    </body>
</html>
