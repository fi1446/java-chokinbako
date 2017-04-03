<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList" import="beans.CategoryCheckBeans"
    pageEncoding="UTF-8"%>
<%@ page import="helper.NameExtractor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
<input value="もどる" onclick="history.back();" type="button">
</form>
<% for (int num=1; num<=4; num++) { %>
<div>
<% ArrayList<CategoryCheckBeans> list = (ArrayList<CategoryCheckBeans>) session.getAttribute("list" + num); %>
<% String s; %>
<% int n; %>
<% if (list != null) { %>
<% if (session.getAttribute("category" + num) != null) { %>
<h3><%= NameExtractor.extractCategoryName((String) session.getAttribute("category" + num)) %></h3>
理解できた数：<%=session.getAttribute("categoryAllChecked" + num)%>
<% } %>
<% for (int i=0; i<list.size(); i++) { %>
<p>
<%=session.getAttribute("topic" + num + "_" + (i+1))%>: 
<% s = (String) session.getAttribute("check" + num + "_" + (i+1)); %>
<% if (s.equals("null") || s.equals("")) { n = 9999; } else { %>
<% try { n = Integer.parseInt(s); } catch (NumberFormatException e) { n = 9999; } %>
<% } %>
<% if (n == 1) { %>
<img src='<%=request.getContextPath()+"/img/check.png"%>'>
<% } else if (n == 0) { %>
<img src='<%=request.getContextPath()+"/img/notyet.png"%>'>
<% } %>
</p>
<% s = (String) session.getAttribute("memo" + num + "_" + (i+1)); %>
<% if (!(s.equals("null")) || !(s.equals(""))) { %>
<pre><%=session.getAttribute("memo" + num + "_" + (i+1))%></pre>
<% } %>
<% } %>
<form action="StudentChecklistEditServlet" method="post">
  <input type="hidden" name="category_num" value="<%= num %>">
  <input type="submit" value="このリストを編集する">
</form>
<% } %>
</div>
<% } %>
	
</body>
</html>