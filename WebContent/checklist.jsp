<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList" import="beans.CategoryCheckBeans" pageEncoding="UTF-8" %>
<%@ page import="helper.NameExtractor" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学習チョキン箱</title>
  </head>
  <body>
    <header id="header">
      <h1>学習チョキン箱</h1>
      <form>
        <input value="もどる" onclick="history.back();" type="button">
      </form>
    </header>
    <% for (int num=1; num<=4; num++) { %>
  	<div id="main">
      <% ArrayList<CategoryCheckBeans> list = (ArrayList<CategoryCheckBeans>) session.getAttribute("list" + num); %>
      <% String s; %>
      <% int n; %>
      <% if (list != null) { %>
      <% if (session.getAttribute("category" + num) != null) { %>
      <h3><%= NameExtractor.extractCategoryName((String) session.getAttribute("category" + num)) %></h3>
      <p>理解できた数：<%=session.getAttribute("categoryAllChecked" + num)%></p>
      <% } %>
      <% for (int i=0; i<list.size(); i++) { %>
      <p>
        <%=session.getAttribute("topic" + num + "_" + (i+1))%>:
        <% s = (String) session.getAttribute("check" + num + "_" + (i+1)); %>
        <% if (s.equals("null") || s.equals("")) { n = 9999; } else { %>
        <% try { n = Integer.parseInt(s); } catch (NumberFormatException e) { n = 9999; } %>
        <% } %>
        <% if (n == 1) { %>
        <span><img src='<%=request.getContextPath()+"/img/check.png"%>'></span>
        <% } else if (n == 0) { %>
        <span><img src='<%=request.getContextPath()+"/img/notyet.png"%>'></span>
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
      <% } %>
    </div>
    <footer id="footer">
  		<small id="copyright">@2017 Kameda</small>
  	</footer>
  </body>
</html>
