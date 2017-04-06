<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			<h1>コースの編集</h1>
			<form action="TeacherRegisterServlet" method="post">
				<p>コース名：<input type="text" name="course_name"></p>
				<p>カテゴリ名①：<input type="text" name="gcategory_name_1"></p>
				<p>カテゴリ名②：<input type="text" name="category_name_2"></p>
				<p>カテゴリ名③：<input type="text" name="category_name_3"></p>
				<p>カテゴリ名④：<input type="text" name="category_name_4"></p>
				<p>生徒共通パスワード：<input type="password" name="password"></p>
				<p>カテゴリ項目、生徒情報のCSVは指定された場所に、最大4つまで配置してください（自動で読み込みます）。
				カテゴリが4つに満たない場合でも、その分だけのCSVファイルを配置することで対応します。</p>
				<p><input type="submit"></p>
			</form>
		</div>
		<footer id="footer">
			<small id="copyright">©totomoni</small>
		</footer>
</body>
</html>
