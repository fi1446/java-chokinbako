<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header id="header">
	<h1>学習チョキン箱</h1>
	<div id="back">
		<a href="#">もどる</a>
	</div>
	</header>
	<div id="main">
		<h1>コースの編集</h1>
		<form action="TeacherRegisterServlet" method="post">
			コース名：<input type="text" name="course_name">
			<br>
			カテゴリ名①：<input type="text" name="category_name_1">
			<br>
			カテゴリ名②：<input type="text" name="category_name_2">
			<br>
			カテゴリ名③：<input type="text" name="category_name_3">
			<br>
			カテゴリ名④：<input type="text" name="category_name_4">
			<br>
			生徒共通パスワード：<input type="password" name="password">
			<br><br>
			カテゴリ項目、生徒情報のCSVは指定された場所に、最大4つまで配置してください（自動で読み込みます）。
			<br>
			カテゴリが4つに満たない場合でも、その分だけのCSVファイルを配置することで対応します。
			<br><br>
			<input type="submit">
			<br>
		</form>
	</div>
	<footer id="footer">
	<small id="copyright">©totomoni</small>
	</footer>
</body>
</html>