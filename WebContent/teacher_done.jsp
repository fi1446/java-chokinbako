<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Collections" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>学習チョキン箱</title>
  </head>
  <body>
    <header id="header">
      <h1>学習チョキン箱</h1>
    </header>
    <div id="main">
      <p>コースの新規登録が完了しました。</p>
      <form action="TeacherDashboardServlet" method="post">
      	<input type="hidden" name="teacher_loginid" value="<%= session.getAttribute("id") %>">
      	<input type="hidden" name="teacher_password" value="<%= session.getAttribute("password") %>">
      	<input type="submit" value="トップ画面へ戻る">
      </form>
    </div>
    <footer id="footer">
      <small id="copyright">@2017 Kameda</small>
    </footer>
  </body>
</html>
