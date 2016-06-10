<%@ page pageEncoding="utf-8" %>
<% String center = (String) request.getAttribute("center"); %>
<%if(center.equals("index")) { %>
<%@ include file="/View/index.jsp"%>
<% } else if(center.equals("Error")) { %>
<%@ include file="/View/Error.jsp"%>
<% } else if(center.equals("login")) { %>
<%@ include file="/View/login.jsp"%>
<% } else if(center.equals("aboutus")) { %>
<%@ include file="/View/Detail.jsp"%>
<% } else if(center.equals("contact")) { %>
<%@ include file="/View/Detail.jsp"%>
<% } else if(center.equals("recruit")) { %>
<%@ include file="/View/Detail.jsp"%>
<% } else if(center.equals("Sanpham")) { %>
<%@ include file="/View/Sanpham.jsp"%>
<% } else if(center.equals("Dichvu")) { %>
<%@ include file="/View/Dichvu.jsp"%>
<% } else if(center.equals("Dichvuct")) { %>
<%@ include file="/View/Dichvuct.jsp"%>
<% }%>	
