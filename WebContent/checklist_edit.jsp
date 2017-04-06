<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList" import="beans.CategoryCheckBeans" pageEncoding="UTF-8" %>
<%@ page import="helper.NameExtractor" %>
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
			<form action="StudentChecklistUpdateServlet" method="post">
				<% String category_num = (String) session.getAttribute("category_num"); %>
				<% int catnum = Integer.parseInt(category_num); %>
				<% ArrayList<CategoryCheckBeans> list = (ArrayList<CategoryCheckBeans>) session.getAttribute("list" + category_num); %>
				<h2><%= NameExtractor.extractCategoryName((String) session.getAttribute("category" + category_num)) %></h2>
				<% int num; %>
				<% for (int i=0; i<list.size(); i++) { %>
				<div>
					<%=session.getAttribute("topic" + catnum + "_" + (i+1))%>
					<% String check = (String) session.getAttribute("check" + catnum + "_" + (i+1)); %>
					<% if (check != null && check != "") { %>
					<% try { num = Integer.parseInt(check); } catch (NumberFormatException e) { num = 9999; }%>
					<% } else { num = 9999; } %>
					<% if (num == 1) { %>
					<input type="radio" name="check_<%= i %>" class="check" value="1" checked="checked">理解できた
					<input type="radio" name="check_<%= i %>" class="check" value="0">分からない
					<% } else if (num == 0) { %>
					<input type="radio" name="check_<%= i %>" class="check" value="1">理解できた
					<input type="radio" name="check_<%= i %>" class="check" value="0" checked="checked">分からない
					<% } else { %>
					<input type="radio" name="check_<%= i %>" class="check" value="1">理解できた
					<input type="radio" name="check_<%= i %>" class="check" value="0">分からない
					<% } %>
					<a class="erase" href="">取消</a>
				</div>
				<div>
					<textarea name="memo_<%= i %>">
						<% String memo; %>
						<% memo = (String) session.getAttribute("memo" + catnum + "_" + (i+1)); %>
						<% if (!(memo.equals("null"))) { %>
						<%=session.getAttribute("memo" + catnum + "_" + (i+1))%>
						<% } %>
					</textarea><% } %>
					<input type="hidden" name="category" value="<%= session.getAttribute("category" + category_num) %>">
					<input type="hidden" name="category_num" value="<%= catnum %>">
					<input type="hidden" name="length" value="<%= list.size() %>">
					<input type="submit">
				</div>
			</form>
		</div>
		<footer id="footer">
			<small id="copyright">@2017 Kameda</small>
		</footer>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
		<script>
			$('.erase').click(function(e) {
				e.preventDefault();
				$(this).parent('div').find('input').prop('checked', false);
			});
		</script>
	</body>
</html>
