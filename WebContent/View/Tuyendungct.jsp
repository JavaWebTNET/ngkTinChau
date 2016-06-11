<%@page import="java.util.Vector"%>
<%@page import="models.TuyenDung" %>
<%@ page pageEncoding="utf-8" %>

<% TuyenDung td=(TuyenDung)request.getAttribute("tuyendung"); %>	
	<div class="col-sm-12 col-xs-12 center-right-one">
	<div class="center-right-title"><%=" "+td.getTitle() %></div>
	<div class="contai-right-dichvu-main">

		<div class="col-sm-9 col-xs-12 right-dichvu-main-nd">
		<p>Ngày Đăng: <%= td.createAt() %></p>
		<p>Ngày Cập nhật mới nhất: <%= td.updateAt() %></p>
		<%= td.getDetail() %>		
		</div>

	</div>
	</div>