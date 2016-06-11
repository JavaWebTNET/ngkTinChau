<%@page import="java.util.Vector"%>
<%@page import="models.TinTuc" %>
<%@ page pageEncoding="utf-8" %>

<% TinTuc tt=(TinTuc)request.getAttribute("tintuc"); %>	
	<div class="col-sm-12 col-xs-12 center-right-one">
	<div class="center-right-title"><%=" "+tt.getTitle() %></div>
	<div class="contai-right-dichvu-main">

		<div class="col-sm-9 col-xs-12 right-dichvu-main-nd">
		<p>Ngày Đăng: <%= tt.createAt() %></p>
		<p>Ngày Cập nhật mới nhất: <%= tt.updateAt() %></p>
		<%= tt.getDetail() %>		
		</div>

	</div>
	</div>