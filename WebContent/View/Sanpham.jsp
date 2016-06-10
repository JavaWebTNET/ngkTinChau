<%@page import="java.util.Vector"%>
<%@page import="models.DanhMuc" %>
<%@page import="models.SanPham" %>
<%@page import="models.DichVu" %>
<%@ page pageEncoding="utf-8" %>

<% DanhMuc dam=(DanhMuc)request.getAttribute("dam"); %>
<% @SuppressWarnings("unchecked")
Vector<SanPham> vtsp=(Vector<SanPham>)request.getAttribute("sanpham"); %>
<% @SuppressWarnings("unchecked")
Vector<DichVu> vtdv=(Vector<DichVu>)request.getAttribute("dichvu"); %>
	
	<div class="col-sm-12 col-xs-12 center-right-one">
	<div class="center-right-title">Sản Phẩm<%=dam!=null?" - "+dam.getTitle():"" %></div>
	<div><br/>
	<%=dam!=null?dam.getDetail():"" %>
	</div>
	<%@ include file="/View/paginate.jsp"%>
	<div class="col-sm-12 col-xs-12 center-right-main">
	<!-- ---- -->
	<% int i=1; 
		for(SanPham sp: vtsp) {
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

	<!-- ------ -->
	<div class="col-sm-12 col-xs-12 contai-right-dichvu">
	<div class="center-right-title">Dịch Vụ</div>
	<% for(DichVu item:vtdv){ %>
	
	<div class="contai-right-dichvu-main">
		<div class="col-sm-12 col-xs-12 right-dichvu-main-title">
		<a href="<%=request.getContextPath() %>/dichvu/<%=item.getId_dv() %>"><%=item.getName_dv() %></a>
		</div>
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
