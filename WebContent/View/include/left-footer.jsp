<%@ page pageEncoding="utf-8" %>
<%@page import="models.ThongTin" %>
<%@page import="java.util.HashMap" %>
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
	<% @SuppressWarnings("unchecked")
		HashMap<String, Integer> mecks = (HashMap<String, Integer>)request.getAttribute("mecks");
	%>
	<!-- --------------- -->
	<div class="col-sm-12 col-xs-12 center-left-trc">
		<div class="title-left">Thống Kê Truy Cập</div>
		<p>Đang Online : <span><%=mecks.get("online") %></span></p>
		<p>Truy Cập Hôm Nay: <span><%=mecks.get("visit_today") %></span></p>
		<p>Truy Cập Hôm Qua: <span><%=mecks.get("visit_yesterday") %></span></p>
		<p>Truy Cập Tháng Này: <span><%=mecks.get("visit_month") %></span></p>
		<p>Truy Cập Năm Nay: <span><%=mecks.get("visit_year") %></span></p>
		<p>Tổng Số Truy Cập: <span><%=mecks.get("visit_total") %></span></p>
	</div>

	<!-- --------------- -->
	 		