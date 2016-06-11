
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.HashMap"%>
<%@page import="models.DanhMuc"%>
<%@page import="java.util.Vector"%>
<%@ page pageEncoding="utf-8" %>
 
<!-- menu one -->
<div class="col-sm-12 col-xs-12 menu-left-one-child">
<div class="title-left">Quản Lý </div>
<div class="menu-left-one-admin">
					
	<ul class="nav ul-menu-one">
		<li><a href="${ pageContext.request.contextPath}/admin/danhmuc">Quản Lý Danh Mục <%="&" %> Sản Phẩm</a></li>					
		<li><a href="${ pageContext.request.contextPath}/admin/thongtin">Quản lý thông tin</a></li>													
		<li><a href="${ pageContext.request.contextPath}/admin/dichvu">Quản lý dich vụ </a></li>					
		<li><a href="${ pageContext.request.contextPath}/admin/slider">Quản lý slider</a> </li>
		<li><a href="${ pageContext.request.contextPath}/admin/tintuc">Quản lý tin tức</a> </li>	
		<li><a href="${ pageContext.request.contextPath}/admin/tuyendung">Quản lý tuyển dụng</a> </li>			
		<li><a href="${ pageContext.request.contextPath}/admin/changepw">Đổi mật khẩu </a></li>
		<li><a href="${ pageContext.request.contextPath}/logout">Đăng xuất </a></li>		
	</ul>
					
</div>
</div>
<!-- ---------- -->