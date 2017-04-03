<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>コース情報、それに紐づく生徒情報（生徒固有のチェックリスト含）の削除操作は取り消すことが出来ません。<br>
本当に削除してもよろしいですか？</p>
<form action="TeacherDeleteConfirmServlet" method="post">
	<input type="submit" value="コース情報を全て削除する">
</form>
</body>
</html>