<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="helper.NameExtractor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LogoutServlet" method="post">
		<input type="submit" value="ログアウトする">
	</form>
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
</body>
</html>