<%@page import="java.util.Vector"%>
<%@page import="models.SanPham" %>
<%@page import="models.TuyenDung" %>
<%@ page pageEncoding="utf-8" %>

<% @SuppressWarnings("unchecked")
Vector<SanPham> vtspm=(Vector<SanPham>)request.getAttribute("sanphammoi"); %>
<% @SuppressWarnings("unchecked")
Vector<TuyenDung> vttd=(Vector<TuyenDung>)request.getAttribute("tuyendung"); %>

	<div class="col-sm-12 col-xs-12 contai-right-dichvu">
	<div class="center-right-title">Tuyển Dụng</div>
	<%@ include file="/View/paginate.jsp"%>
	<% for(TuyenDung item:vttd){ %>	
	<div class="contai-right-dichvu-main">
		<div class="col-sm-12 col-xs-12 right-dichvu-main-title">
		<a href="<%=request.getContextPath() %>/tuyendung/<%=item.getId() %>"><%=item.getTitle() %></a>
		</div>
		<div class="col-sm-12 col-xs-12 right-dichvu-main-nd">
		<p>Ngày Đăng: <%= item.createAt() %></p>
		<p>Ngày Cập nhật mới nhất: <%= item.updateAt() %></p>
		<p><%= item.subDetail() %></p>		
		</div>

	</div>
		
	<%} %>
		
	</div>
	<br/>
	<div class="col-sm-12 col-xs-12 center-right-one">
	<div class="center-right-title">Sản Phẩm</div>

	<div class="col-sm-12 col-xs-12 center-right-main">
	<!-- ---- -->
	<% int i=1; 
		for(SanPham sp: vtspm) {
			if(i%3==1) {
				%>
		<div class="row">
		<div class="col-sm-4 col-xs-12 center-right-main-child-one">
			<div class="center-right-main-child-sp">
			<img src="<%=sp.imageLink(request) %>">
			<a href="<%=request.getContextPath() %>/sanpham/<%=sp.getSuper_id() %>"><%=sp.getTitle() %></a>
			</div>
		</div>
				<%
			}
			else if(i%3==2) {
				%>
		<div class="col-sm-4 col-xs-12 center-right-main-child-tow">
			<div class="center-right-main-child-sp">
			<img src="<%=sp.imageLink(request) %>">
			<a href="<%=request.getContextPath() %>/sanpham/<%=sp.getSuper_id() %>"><%=sp.getTitle() %></a>
			</div>
		</div>
				<%
			}
			else {
				%>
		<div class="col-sm-4 col-xs-12 center-right-main-child-three">
			<div class="center-right-main-child-sp">
			<img src="<%=sp.imageLink(request) %>">
			<a href="<%=request.getContextPath() %>/sanpham/<%=sp.getSuper_id() %>"><%=sp.getTitle() %></a>
			</div>
		</div>
				<%
			}
			if(i%3==0) {
				%>
		</div>
				<%
			}
			i++;
		}
	%>
	</div>
	</div>
