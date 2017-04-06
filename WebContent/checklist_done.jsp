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
	</header>
  	<div id="main">
      <p>チェックリストの編集が完了しました。</p>
      <form action="StudentDashboardServlet" method="post">
      	<input type="hidden" name="email" value="<%= session.getAttribute("email") %>">
      	<input type="hidden" name="password" value="<%= session.getAttribute("password") %>">
      	<input type="submit" value="リストへ戻る">
      </form>
    </div>
    <footer id="footer">
      <small id="copyright">@2017 Kameda</small>
    </footer>
  </body>
</html>
