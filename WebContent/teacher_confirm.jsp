<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Collections" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
コース名：<%= session.getAttribute("course_name") %>
<br>
<% for (int i=1; i<=4; i++) { %>
<% String name; %>
<% name = (String) session.getAttribute("category_name_" + i); %>
<% if (String.valueOf(name) == "null") { break; } %>
カテゴリ<%= i %>：<%= session.getAttribute("category_name_" + i) %>
<br>
項目数：<%= session.getAttribute("topic" + i + "_num") %>
<br>
<% } %>
<br>
<% String password = (String) session.getAttribute("password"); %>
<% int password_length = (int) password.length(); %>
<% String hidden_password = String.join("", Collections.nCopies(password_length, "●")); %>
生徒共通パスワード：<%= hidden_password %>
<br><br>
<% int c_num = (int) session.getAttribute("categories_num"); %>
<% for (int i=1; i<=c_num; i++) { %>
カテゴリ<%= i %>項目：
<br>
<% int t_num = (int) session.getAttribute("topic" + i + "_num"); %>
<% for (int j=1; j<=t_num; j++) { %>
<% String topic; %>
<% topic = (String) session.getAttribute("topic" + i + "_" + j); %>
<% if (String.valueOf(topic) == "null") { break; } %>
項目<%= j %>：<%= session.getAttribute("topic" + i + "_" + j) %>
<br>
<% } %>
<br>
<% } %>

<% int s_num = (int) session.getAttribute("student_num"); %>
<% for (int i=0; i<s_num; i++) { %>
<%= session.getAttribute("student" + i + "_name") %>
<%= session.getAttribute("student" + i + "_email") %>
<br>
<% } %>
<br>
<form action="TeacherRegisterConfirmServlet" method="post">
以上でよろしいでしょうか？
<br>
<input type="hidden" name="teachers_id" value="<%= session.getAttribute("teacher_id") %>">
<input type="submit">
</form>

</body>
</html>