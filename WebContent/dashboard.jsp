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
	<div>
		<p><%=session.getAttribute("studentName")%>さんの演習理解度は、</p>
		<h2><%=session.getAttribute("allChecked")%> / <%= session.getAttribute("listcheckAll") %></h2>
		です。コツコツためていきましょう！
	</div>
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

</body>
</html>