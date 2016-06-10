<%@ page pageEncoding="utf-8" %>
<%@ page import="lang.Lang" %>
<% Lang lang = new Lang(); %>
<% String keytt = (String)request.getAttribute("center"); %>
<% String valuett = (String)request.getAttribute("detail"); %>
<div class="center-right-title"><%=lang.getMessage(keytt) %></div>
<%@ include file="/View/flash.jsp" %>	
<div class="col-sm-12 col-xs-12 center-right-main-admin">
  <div class="center-right-main-admin-child"> 	
		  <%=valuett %>
  </div>
</div>
