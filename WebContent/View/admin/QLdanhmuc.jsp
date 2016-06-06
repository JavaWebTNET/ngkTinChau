
<%@page import="models.DanhMuc"%>
<%@page import="models.SanPham"%>
<%@page import="java.util.Vector"%>
<%@ page pageEncoding="utf-8" %>
<% @SuppressWarnings("unchecked")
Vector<DanhMuc> vtdanhmuc=(Vector<DanhMuc>) request.getAttribute("danhmuc"); %>
<% DanhMuc dam = (DanhMuc) request.getAttribute("dam"); %>
<% boolean canAddDM = (boolean) request.getAttribute("canAddDM"); %>
	<% if(canAddDM) {%>
	<div class="col-sm-12 col-xs-12 center-right-main-admin">
	<div class="center-right-title">Quản lý Danh Mục<%=(dam!=null)? " - "+ dam.getTitle(): "" %></div>
	<div class="center-right-main-admin-child"> 				
	<%@include file="/View/flash.jsp" %>
	<div class="table-responsive" style="padding-left:10px;padding-right:10px;">
        <table class="table table-bordered table-condensed table-qlslider">
            <tr class="title-table" style="color:#00ff21;height:45px;background-color:#808080">       
                <th>STT</th>
                <th>Tiêu đề</th>                                           
                <th style="color:red;" colspan=2>Chức năng</th>
            </tr>
       		<% if(vtdanhmuc.size()>0) {
       		int i=1;
       		for(DanhMuc item:vtdanhmuc){
       		%>
                <tr class="title-noidung">
                    <td>
                      <%= i %>
                    </td>
                    <td>
                     <a href="${ pageContext.request.contextPath}/admin/danhmuc/<%= item.getId()%>"><%=item.getTitle() %></a>
                    </td>
                    <td> 
                     <form role="form" method="get" 
                     action="${ pageContext.request.contextPath}/admin/danhmuc/<%= item.getId()%>/edit">
                        <div class="col-sm-2"><button type="submit" class="btn btn-info">Sửa</button></div>
                     </form>
                    </td>  
                    <td> 
                     <form role="form" method="post" 
                     action="${ pageContext.request.contextPath}/admin/danhmuc/<%= item.getId()%>/delete">
                       <button type="submit" class="btn btn-danger" onclick="return window.confirm('Xoá?');">Xoá</button>
                     </form>
                    </td>                                          
                </tr>                            
			<%i++;
			}
       		}%>
      	</table>
   	</div> 			
	<form class="form-horizontal" role="form" action="${ pageContext.request.contextPath}/admin/danhmuc/<%=dam!=null?dam.getId():""%>/create" method="get" >
	 	<div class="form-group"> 	
	    	<div class="col-sm-4"><input class="btn btn-primary" type="submit" value="Thêm Danh Mục" /></div>       
	    </div>		 				 				 			
	</form>
	</div>	
	</div>
	<% } %>
<% @SuppressWarnings("unchecked")
Vector<SanPham> vtsanpham=(Vector<SanPham>) request.getAttribute("sanpham"); %>
	
	<%if(dam != null) {%>
	<div class="col-sm-12 col-xs-12 center-right-main-admin">
	<div class="center-right-title">Quản lý Sản Phẩm</div>
	<div class="center-right-main-admin-child"> 				
	
	<form role="form" action="${ pageContext.request.contextPath}/admin/danhmuc/<%=dam.getId()%>/createsp" method="get" >
	 	<div class="form-group"> 	
	    	<div class="col-sm-4"><input class="btn btn-primary" type="submit" value="Thêm Sản Phẩm" /></div>       
	    </div>		 				 				 			
	</form>
	<div class="table-responsive" style="padding-left:10px;padding-right:10px;">
        <table class="table table-bordered table-condensed table-qlslider">
            <tr class="title-table" style="color:#00ff21;height:45px;background-color:#808080">       
                <th>STT</th>
                <th>Hình ảnh</th> 
                <th>Tiêu đề</th>                                           
                <th style="color:red;" colspan=3>Chức năng</th>
            </tr>
       		<% if(vtsanpham.size()>0) {
       		int i=1;
       		for(SanPham item:vtsanpham){
       		%>
                <tr class="title-noidung">
                    <td>
                      <%= i %>
                    </td>
                    <td class="slider-td-img">
                     <img src="<%=item.imageLink(request) %>">
                    </td>
                    <td>
                    	<%=item.getTitle() %>
                    </td>
                    <td> 
                     <form role="form" method="post" 
                     action="${ pageContext.request.contextPath}/admin/danhmuc/<%= item.getId()%>/prosp">
                        <button type="submit" class="btn btn-<%=item.isProminent()?"info":"primary" %>">
                        <%=item.isProminent()?"Tắt nổi bật":"Chọn nổi bật" %></button>
                     </form>
                    </td>  
                    <td> 
                     <form role="form" method="get" 
                     action="${ pageContext.request.contextPath}/admin/danhmuc/<%= item.getId()%>/editsp">
                        <button type="submit" class="btn btn-info">Sửa</button>
                     </form>
                    </td>  
                    <td> 
                     <form role="form" method="post" 
                     action="${ pageContext.request.contextPath}/admin/danhmuc/<%= item.getId()%>/deletesp">
                       <button type="submit" class="btn btn-danger" onclick="return window.confirm('Xoá?');">Xoá</button>
                     </form>
                    </td>                                          
                </tr>                            
			<%i++;
			}}
       		%>
      	</table>
   	</div> 	
   	<%@ include file="/View/paginate.jsp" %>		
	</div>	
	</div>
	<% } %>
	 			