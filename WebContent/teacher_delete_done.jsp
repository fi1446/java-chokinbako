<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>コース情報をすべて削除しました。</p>
<form action="TeacherDashboardServlet" method="post">
	<input type="hidden" name="teacher_loginid" value="<%= session.getAttribute("id") %>">
	<input type="hidden" name="teacher_password" value="<%= session.getAttribute("password") %>">
	<input type="submit" value="トップ画面へ戻る">
</form>
</body>
</html>