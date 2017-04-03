<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.ArrayList" import="beans.CategoryCheckBeans"
	pageEncoding="UTF-8"%>
<%@ page import="helper.NameExtractor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()+"/js/jquery-3.2.0.min.js"%>"></script>
<script type="text/javascript" src="<%=request.getContextPath()+"/js/checklist_erase.js"%>"></script>
<title>Insert title here</title>
</head>
<body>
<form>
<input value="もどる" onclick="history.back();" type="button">
</form>
	<form action="StudentChecklistUpdateServlet" method="post">
		<% String s; %>
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
		<textarea name="memo_<%= i %>"><% s = (String) session.getAttribute("memo" + catnum + "_" + (i+1)); %><% if (String.valueOf(s) != "null") { %><%=session.getAttribute("memo" + catnum + "_" + (i+1))%><% } %></textarea><% } %>
		<input type="hidden" name="category" value="<%= session.getAttribute("category" + category_num) %>">
		<input type="hidden" name="category_num" value="<%= catnum %>">
		<input type="hidden" name="length" value="<%= list.size() %>">
		<input type="submit">
	</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
$('.erase').click(function(e) {
	e.preventDefault();
	$(this).parent('div').find('input').prop('checked', false);
});
</script>
</body>
</html>