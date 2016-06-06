<%@ page pageEncoding="utf-8" %>
<% String center = (String) request.getAttribute("center"); %>
<%if(center.equals("index")) { %>
<%@ include file="/View/index.jsp"%>
<% } else if(center.equals("Error")) { %>
<%@ include file="/View/Error.jsp"%>
<% } else if(center.equals("login")) { %>
<%@ include file="/View/login.jsp"%>
<% } %>	
