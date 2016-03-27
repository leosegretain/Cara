<%--
  Created by IntelliJ IDEA.
  User: Léo
  Date: 09/02/2016
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
  response.setStatus(response.SC_MOVED_PERMANENTLY);
  response.setHeader("Location", "/welcome");
%>
</html>
