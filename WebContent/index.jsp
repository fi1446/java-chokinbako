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
      <p>学習チョキン箱は、トトモニ校による演習科目チェックリストです<br> 理解できた！と思った課題にコツコツとチェックをつけていくことで、あなたの学習の貯金が貯まっていきます</p>
      <form action="StudentDashboardServlet" method="post">
        <p>登録時に学校に渡したアドレスと、担任の先生からもらったパスワードを入れてください</p>
        <p>メールアドレス：<input type="text" name="email"></p>
        <p>パスワード：<input type="password" name="password"></p>
        <p><input type="submit"></p>
      </form>
      <form action="TeacherDashboardServlet" method="post">
        <h2>先生用ログイン</h2>
        <p>ログインID：<input type="text" name="teacher_loginid"></p>
        <p>パスワード：<input type="password" name="teacher_password"></p>
        <input type="submit">
      </form>
      <footer id="footer">
    		<small id="copyright">@2017 Kameda</small>
    	</footer>
    </div>
  </body>
</html>
