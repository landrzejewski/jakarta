<%--
  Created by IntelliJ IDEA.
  User: landr
  Date: 18.06.2022
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jakarta</title>
</head>
<body>
<%!
    private static final String NAME_PARAMETER = "name";

    private String formatName(String name) {
        return name == null ? "" : name;
    }
%>
<p>
    Hello <%
        String name = request.getParameter(NAME_PARAMETER);
        out.println(formatName(name));
    %>
</p>
</body>
</html>
