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
      <form>
        <input value="もどる" onclick="history.back();" type="button">
      </form>
    </header>
    <div id="main">
      <h2>コース名：<%= session.getAttribute("course_name") %></h2>
      <% for (int i=1; i<=4; i++) { %>
      <% String name; %>
      <% name = (String) session.getAttribute("category_name_" + i); %>
      <% if (name.equals("null")) { break; } %>
      <p>カテゴリ<%= i %>：<%= session.getAttribute("category_name_" + i) %></p>
      <p>項目数：<%= session.getAttribute("topic" + i + "_num") %></p>
      <% } %>
      <% String password = (String) session.getAttribute("password"); %>
      <% int password_length = (int) password.length(); %>
      <% String hidden_password = String.join("", Collections.nCopies(password_length, "●")); %>
      <p>生徒共通パスワード：<%= hidden_password %></p>
      <% int c_num = (int) session.getAttribute("categories_num"); %>
      <% for (int i=1; i<=c_num; i++) { %>
      <p>カテゴリ<%= i %>項目：</p>
      <% int t_num = (int) session.getAttribute("topic" + i + "_num"); %>
      <% for (int j=1; j<=t_num; j++) { %>
      <% String topic; %>
      <% topic = (String) session.getAttribute("topic" + i + "_" + j); %>
      <% if (topic.equals("null")) { break; } %>
      <p>項目<%= j %>：<%= session.getAttribute("topic" + i + "_" + j) %></p>
      <% } %>
      <% } %>
      <% int s_num = (int) session.getAttribute("student_num"); %>
      <% for (int i=0; i<s_num; i++) { %>
      <p><%= session.getAttribute("student" + i + "_name") %></p>
      <p><%= session.getAttribute("student" + i + "_email") %></p>
      <% } %>
      <form action="TeacherRegisterConfirmServlet" method="post">
        <p>以上でよろしいでしょうか？</p>
        <input type="hidden" name="teachers_id" value="<%= session.getAttribute("teacher_id") %>">
        <input type="submit">
      </form>
    </div>
    <footer id="footer">
      <small id="copyright">@2017 Kameda</small>
    </footer>
  </body>
</html>
