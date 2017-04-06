<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="helper.NameExtractor"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>学習チョキン箱</title>
  </head>
  <body>
    <header id="header">
      <h1>学習チョキン箱</h1>
      <form action="LogoutServlet" method="post">
        <input type="submit" value="ログアウトする">
      </form>
    </header>
    <div id="main">
      <h2>コース情報</h2>
      <p><%= session.getAttribute("teacher_name") %>先生のコース情報です</p>
      <% String registered = (String) session.getAttribute("teacher_registered"); %>
      <% if (registered.equals("0")) { %>
      <p>生徒がチェックリストを利用するためには、まず先生がコースを登録しないといけません。</p>
      <form action="TeacherRegisterNewServlet" method="post">
        <input type="submit" value="コースを登録する">
      </form>
      <% } else { %>
      <p>コース名：<%= session.getAttribute("teacher_course_name") %></p>
      <% int length = (int) session.getAttribute("teacher_categories_num"); %>
      <% for (int i=1; i<=length; i++) { %>
      <% String name = (String) session.getAttribute("teacher_category" + i); %>
      <% if (!(name.equals(""))) { %>
      <p>カテゴリ<%= i %>：<%= NameExtractor.extractCategoryName((String) session.getAttribute("teacher_category" + i)) %></p>
      <% } %>
      <% } %>
      <p>生徒数：<%= session.getAttribute("teacher_students_num") %></p>
      <form action="TeacherDeleteServlet" method="post">
        <input type="submit" value="終了したので、コースを削除する">
      </form>
      <% } %>
    </div>
    <footer id="footer">
      <small id="copyright">@2017 Kameda</small>
    </footer>
  </body>
</html>
