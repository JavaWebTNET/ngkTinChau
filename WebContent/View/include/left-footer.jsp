<%@ page pageEncoding="utf-8" %>
<%@page import="models.ThongTin" %>
<% ThongTin thongtinleft=(ThongTin) request.getAttribute("thongtin"); %>
	<!-- ---------- -->
	<div class="col-sm-12 col-xs-12 center-left-td">
	<div class="title-left">Tuyển Dụng</div>
	<img src="<%=request.getContextPath()%>/View/Image/tuyendung.png">	
	</div>

	<!-- --------------- -->
	<div class="col-sm-12 col-xs-12 center-left-lh">
		<div class="title-left">Liên Hệ</div>
		<p>Hotline:<%=thongtinleft.getHotline() %></p>
		<p>Email:<%=thongtinleft.getEmail() %></p>
	</div>

	<!-- --------------- -->

	<!-- --------------- -->
	<div class="col-sm-12 col-xs-12 center-left-bd">
		<div class="title-left">Bản Đồ</div>
		<a href="#"><img src="<%=request.getContextPath()%>/View/Image/bando.png"></a>
	</div>

	<!-- --------------- -->
	<!-- --------------- -->
	<div class="col-sm-12 col-xs-12 center-left-trc">
		<div class="title-left">Thống Kê Truy Cập</div>
		<p>Đang Online : <span>22</span></p>
		<p>Tổng Số Truy Cập : <span>1111</span></p>
	</div>

	<!-- --------------- -->
	 		