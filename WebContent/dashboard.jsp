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
      <div>
    		<p><%=session.getAttribute("studentName")%>さんの演習理解度は、</p>
    		<h2><%=session.getAttribute("allChecked")%> / <%= session.getAttribute("listcheckAll") %></h2>
    		<p>です。コツコツためていきましょう！</p>
    	</div>
      <div>
      	<p>各カテゴリ項目の理解度</p>
      	<% for (int i=1; i<=4; i++) { %>
      	<% String name = (String) session.getAttribute("category" + i); %>
      	<% if (!(name.equals(""))) { %>
      	<p><%=NameExtractor.extractCategoryName((String) session.getAttribute("category" + i))%>: <%=session.getAttribute("categoryAllChecked" + i)%> / <%=session.getAttribute("categoryListcheckAll" + i)%></p>
      	<% } %>
      	<% } %>
      	<form action="StudentChecklistServlet" method="post">
      		<input type="submit" value="チェックリストを見る">
      	</form>
      </div>
    </div>
    <footer id="footer">
      <small id="copyright">@2017 Kameda</small>
    </footer>
  </body>
</html>
