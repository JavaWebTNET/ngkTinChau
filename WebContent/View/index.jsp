<%@page import="java.util.Vector"%>
<%@page import="models.DichVu" %>
<%@ page pageEncoding="utf-8" %>
<% @SuppressWarnings("unchecked")
Vector<DichVu> vtdv=(Vector<DichVu>)request.getAttribute("dichvu"); %>
	
	<div class="col-sm-12 col-xs-12 center-right-one">
	<div class="center-right-title">Sản Phẩm</div>

	<div class="col-sm-12 col-xs-12 center-right-main">
	<!-- ---- -->
	<div class="row">
		<div class="col-sm-4 col-xs-12 center-right-main-child-one">
			<div class="center-right-main-child-sp">
				<img src="<%=request.getContextPath()%>/View/Image/sp1.png">
				<a>Cửa sổ mở trượt</a>
			</div>
		</div>

		<div class="col-sm-4 col-xs-12 center-right-main-child-tow">
			<div class="center-right-main-child-sp">
				<img src="<%=request.getContextPath()%>/View/Image/sp2.png">
				<a>Vách ngăn hệ</a>
			</div>
		</div>

		<div class="col-sm-4 col-xs-12 center-right-main-child-three">
			<div class="center-right-main-child-sp">
				<img src="<%=request.getContextPath()%>/View/Image/sp3.png">
				<a>Cửa mở quay</a>
			</div>
		</div>
	</div>

	<!-- ---- -->
	<div class="row">
		<div class="col-sm-4 col-xs-12 center-right-main-child-one">
			<div class="center-right-main-child-sp">
				<img src="<%=request.getContextPath()%>/View/Image/sp1.png">
				<a>Cửa sổ mở trượt</a>
			</div>
		</div>

		<div class="col-sm-4 col-xs-12 center-right-main-child-tow">
			<div class="center-right-main-child-sp">
				<img src="<%=request.getContextPath()%>/View/Image/sp2.png">
				<a>Vách ngăn hệ</a>
			</div>
		</div>

		<div class="col-sm-4 col-xs-12 center-right-main-child-three">
			<div class="center-right-main-child-sp">
				<img src="<%=request.getContextPath()%>/View/Image/sp3.png">
				<a>Cửa mở quay</a>
			</div>
		</div>
	</div>
		
	<!-- 	-- -->
	<div class="row">
		<div class="col-sm-4 col-xs-12 center-right-main-child-one">
			<div class="center-right-main-child-sp">
				<img src="<%=request.getContextPath()%>/View/Image/sp1.png">
				<a>Cửa sổ mở trượt</a>
			</div>
		</div>

		<div class="col-sm-4 col-xs-12 center-right-main-child-tow">
			<div class="center-right-main-child-sp">
				<img src="<%=request.getContextPath()%>/View/Image/sp2.png">
				<a>Vách ngăn hệ</a>
			</div>
		</div>

		<div class="col-sm-4 col-xs-12 center-right-main-child-three">
			<div class="center-right-main-child-sp">
				<img src="<%=request.getContextPath()%>/View/Image/sp3.png">
				<a>Cửa mở quay</a>
			</div>
		</div>
	</div>
	<!-- -- -->
	<div class="row">
		<div class="col-sm-4 col-xs-12 center-right-main-child-one">
			<div class="center-right-main-child-sp">
				<img src="<%=request.getContextPath()%>/View/Image/sp1.png">
				<a>Cửa sổ mở trượt</a>
			</div>
		</div>

		<div class="col-sm-4 col-xs-12 center-right-main-child-tow">
			<div class="center-right-main-child-sp">
				<img src="<%=request.getContextPath()%>/View/Image/sp2.png">
				<a>Vách ngăn hệ</a>
			</div>
		</div>

		<div class="col-sm-4 col-xs-12 center-right-main-child-three">
			<div class="center-right-main-child-sp">
				<img src="<%=request.getContextPath()%>/View/Image/sp3.png">
				<a>Cửa mở quay</a>
			</div>
		</div>
	</div>

	<!-- ---- -->

	</div>

	</div>

	<!-- ------ -->
	<div class="col-sm-12 col-xs-12 contai-right-dichvu">
	<div class="center-right-title">Dịch Vụ</div>
	<% for(DichVu item:vtdv){ %>
	
	<div class="contai-right-dichvu-main">
		<div class="col-sm-12 col-xs-12 right-dichvu-main-title"><%= item.getName_dv() %></div>
		<div class="col-sm-3 col-xs-12 right-dichvu-main-img">
			
			<img src="<%= item.imageLink(request) %>">
		</div>
		<div class="col-sm-9 col-xs-12 right-dichvu-main-nd">
		<p><%= item.getDetail() %></p>
			
		</div>

	</div>
		
	<%} %>
		
	</div>
		
	<!-- ------ -->
