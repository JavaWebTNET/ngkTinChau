<%@page import="java.util.Vector"%>
<%@page import="models.DichVu" %>
<%@ page pageEncoding="utf-8" %>

<% DichVu dv=(DichVu)request.getAttribute("dichvu"); %>	
	<div class="col-sm-12 col-xs-12 center-right-one">
	<div class="center-right-title">Dịch Vụ<%=" "+dv.getName_dv() %></div>
	<div class="contai-right-dichvu-main">
		<div class="col-sm-3 col-xs-12 right-dichvu-main-img">
			
			<img src="<%= dv.imageLink(request) %>">
		</div>
		<div class="col-sm-9 col-xs-12 right-dichvu-main-nd">
		<%= dv.getDetail() %>		
		</div>

	</div>
	</div>