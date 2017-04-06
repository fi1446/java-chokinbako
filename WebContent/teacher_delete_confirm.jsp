<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
      <p>コース情報、それに紐づく生徒情報（生徒固有のチェックリスト含）の削除操作は取り消すことが出来ません。<br>
      本当に削除してもよろしいですか？</p>
      <form action="TeacherDeleteConfirmServlet" method="post">
      	<input type="submit" value="コース情報を全て削除する">
      </form>
    </div>
    <footer id="footer">
      <small id="copyright">@2017 Kameda</small>
    </footer>
  </body>
</html>
